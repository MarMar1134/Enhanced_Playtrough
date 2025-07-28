package net.marmar.enhanced_playthrough.entity.bandit.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.marmar.enhanced_playthrough.entity.bandit.Bandit;
import net.marmar.enhanced_playthrough.entity.bandit.anim.BanditAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

public class BanditModel<T extends Bandit> extends HierarchicalModel<T> implements ArmedModel, HeadedModel {
	private final ModelPart bandit;
	private final ModelPart head;
    private final ModelPart leftArm;
	private final ModelPart rightArm;

    public BanditModel(ModelPart root) {
        this.bandit = root.getChild("body");
		this.head = bandit.getChild("head");
        ModelPart arms = bandit.getChild("arms");
		this.leftArm = arms.getChild("left_arm");
		this.rightArm = arms.getChild("right_arm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition legs = body.addOrReplaceChild("legs",
				CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_leg = legs.addOrReplaceChild("left_leg",
				CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, -1.0F, -2.0F,
						4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, -11.0F, 1.0F));

		PartDefinition right_leg = legs.addOrReplaceChild("right_leg",
				CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, -1.0F, -2.0F,
						4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.0F, -11.0F, 1.0F));

		PartDefinition arms = body.addOrReplaceChild("arms",
				CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm = arms.addOrReplaceChild("left_arm",
				CubeListBuilder.create(), PartPose.offset(5.0F, -2.0F, 0.0F));

		PartDefinition left_arm_r1 = left_arm.addOrReplaceChild("left_arm_r1",
				CubeListBuilder.create().texOffs(40, 46).addBox(-2.0F, -11.0F, -2.0F,
						4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, -11.0F, 1.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition right_arm = arms.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(40, 46).addBox(-2.0F, -22.0F, -1.0F,
						4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, -2.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -11.0F, -4.0F,
								8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(24, 0).addBox(-1.0F, -4.0F, -6.0F,
								2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, -23.0F, 1.0F));

		PartDefinition torso = body.addOrReplaceChild("torso",
				CubeListBuilder.create().texOffs(16, 20).addBox(-3.0F, -24.0F, -2.0F,
						8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Bandit entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch);

		this.animateWalk(BanditAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);

		this.setAttackAnimation(entity, ageInTicks);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
		float newNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		float newHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = newNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = newHeadPitch * ((float)Math.PI / 180F);
	}

	private void setAttackAnimation(Bandit entity, float pAgeInTicks){
		if (entity.isAttacking()){
			if (entity.getMainHandItem().isEmpty()) {
				AnimationUtils.animateZombieArms(this.leftArm, this.rightArm, true, this.attackTime, pAgeInTicks);
			} else {
				this.animate(entity.attackAnimationState, BanditAnimations.ATTACK, pAgeInTicks);
			}
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bandit.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return bandit;
	}

	@Override
	public ModelPart getHead() {
		return head;
	}

	protected ModelPart getArm(HumanoidArm pSide) {
		return pSide == HumanoidArm.RIGHT ? this.rightArm : this.leftArm;
	}

	@Override
	public void translateToHand(HumanoidArm pSide, PoseStack pPoseStack) {
		boolean isRightArm = pSide == HumanoidArm.RIGHT;
		ModelPart arm = getArm(pSide);
		this.offsetStackPosition(pPoseStack, isRightArm);
		arm.translateAndRotate(pPoseStack);
	}

	private void offsetStackPosition(PoseStack pPoseStack, boolean pIsRightArm) {
		if (pIsRightArm) {
			pPoseStack.translate(0F, 0.2F, -0.005556875F);
		} else {
			pPoseStack.translate(0F, 0.2F, 0.005556875F);
		}
	}
}