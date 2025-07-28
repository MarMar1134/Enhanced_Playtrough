package net.marmar.enhanced_playthrough.entity.zombieknight.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.marmar.enhanced_playthrough.entity.zombieknight.ZombieKnight;
import net.marmar.enhanced_playthrough.entity.zombieknight.anim.ZombieKnightAnimations;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

public class ZombieKnightModel<T extends ZombieKnight> extends HierarchicalModel<T> implements ArmedModel {
	private final ModelPart body;
	private final ModelPart legs;
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart arms;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart torso;
	private final ModelPart head;

	public ZombieKnightModel(ModelPart root) {
		this.body = root.getChild("body");
		this.legs = this.body.getChild("legs");
		this.left_leg = this.legs.getChild("left_leg");
		this.right_leg = this.legs.getChild("right_leg");
		this.arms = this.body.getChild("arms");
		this.left_arm = this.arms.getChild("left_arm");
		this.right_arm = this.arms.getChild("right_arm");
		this.torso = this.body.getChild("torso");
		this.head = this.body.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -11.0F, 0.0F));

		PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -11.0F, 0.0F));

		PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition left_arm = arms.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(6.0F, -21.0F, 0.0F));

		PartDefinition left_arm_r1 = left_arm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition right_arm = arms.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-6.0F, -21.0F, 0.0F));

		PartDefinition right_arm_r1 = right_arm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
		float newNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		float newHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = newNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = newHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void setupAnim(ZombieKnight entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch);

		this.animateWalk(ZombieKnightAnimations.ZOMBIE_KNIGHT_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);

		AnimationUtils.animateZombieArms(this.left_arm, this.right_arm, entity.isAggressive(), this.attackTime, ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.body;
	}

	public ModelPart getHead() {
		return this.head;
	}

	protected ModelPart getArm(HumanoidArm pSide) {
		return pSide == HumanoidArm.LEFT ? this.left_arm : this.right_arm;
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
			pPoseStack.translate(0.1F, 1.35F, -0.004556875F);
		} else {
			pPoseStack.translate(-0.1F, 1.35F, 0.004556875F);
		}
	}
}