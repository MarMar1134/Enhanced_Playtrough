package net.marmar.enhanced_playthrough.entity.lycan.werellager.model;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.marmar.enhanced_playthrough.entity.lycan.werellager.Werellager;
import net.marmar.enhanced_playthrough.entity.lycan.werellager.anim.WerellagerHumanAnimations;
import net.marmar.enhanced_playthrough.entity.lycan.werellager.anim.WerellagerLycanAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class WerellagerLycanModel<T extends Werellager> extends HierarchicalModel<T> {
	private final ModelPart werellager_lycan;
	private final ModelPart head;
	private final ModelPart ears;
	private final ModelPart left_ear;
	private final ModelPart right_ear;
	private final ModelPart torso;
	private final ModelPart tail;
	private final ModelPart chest;
	private final ModelPart arms;
	private final ModelPart left_arm;
	private final ModelPart left_arm_fingers;
	private final ModelPart right_arm;
	private final ModelPart right_arm_fingers;
	private final ModelPart legs;
	private final ModelPart left_leg;
	private final ModelPart left_leg_fingers;
	private final ModelPart right_leg;
	private final ModelPart right_leg_fingers;

	public WerellagerLycanModel(ModelPart root) {
		this.werellager_lycan = root.getChild("werellager_lycan");
		this.head = this.werellager_lycan.getChild("head");
		this.ears = this.head.getChild("ears");
		this.left_ear = this.ears.getChild("left_ear");
		this.right_ear = this.ears.getChild("right_ear");
		this.torso = this.werellager_lycan.getChild("torso");
		this.tail = this.torso.getChild("tail");
		this.chest = this.torso.getChild("chest");
		this.arms = this.werellager_lycan.getChild("arms");
		this.left_arm = this.arms.getChild("left_arm");
		this.left_arm_fingers = this.left_arm.getChild("left_arm_fingers");
		this.right_arm = this.arms.getChild("right_arm");
		this.right_arm_fingers = this.right_arm.getChild("right_arm_fingers");
		this.legs = this.werellager_lycan.getChild("legs");
		this.left_leg = this.legs.getChild("left_leg");
		this.left_leg_fingers = this.left_leg.getChild("left_leg_fingers");
		this.right_leg = this.legs.getChild("right_leg");
		this.right_leg_fingers = this.right_leg.getChild("right_leg_fingers");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition werellager_lycan = partdefinition.addOrReplaceChild("werellager_lycan", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition head = werellager_lycan.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).addBox(-1.0F, -3.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition ears = head.addOrReplaceChild("ears", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition left_ear = ears.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(49, 10).addBox(0.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 10).addBox(1.0F, -4.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 6).addBox(3.0F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 7).addBox(0.0F, -3.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 7).addBox(2.0F, -3.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(35, 4).addBox(0.0F, -2.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 4).addBox(1.0F, -3.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -10.0F, 0.0F));

		PartDefinition right_ear = ears.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(49, 10).addBox(0.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 10).addBox(1.0F, -4.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 6).addBox(-1.0F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 7).addBox(0.0F, -3.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 7).addBox(2.0F, -3.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(35, 4).addBox(0.0F, -2.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 4).addBox(1.0F, -3.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -10.0F, 0.0F));

		PartDefinition torso = werellager_lycan.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, -18.0F, 0.0F));

		PartDefinition tail = torso.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 3.0F));

		PartDefinition tail_r1 = tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(1, 43).addBox(-1.0F, -1.0603F, -0.658F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition chest = torso.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(18, 19).addBox(-6.0F, -6.0F, -3.0F, 12.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition arms = werellager_lycan.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm = arms.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 21).addBox(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -24.0F, 0.0F));

		PartDefinition left_arm_fingers = left_arm.addOrReplaceChild("left_arm_fingers", CubeListBuilder.create().texOffs(34, 0).addBox(6.0F, -13.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 0).addBox(9.0F, -13.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 0).addBox(7.5F, -13.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 25.0F, 0.0F));

		PartDefinition right_arm = arms.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 21).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -24.0F, 0.0F));

		PartDefinition right_arm_fingers = right_arm.addOrReplaceChild("right_arm_fingers", CubeListBuilder.create().texOffs(34, 0).addBox(6.0F, -13.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 0).addBox(9.0F, -13.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 0).addBox(7.5F, -13.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, 25.0F, 0.0F));

		PartDefinition legs = werellager_lycan.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(22, 39).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -12.0F, 0.0F));

		PartDefinition left_leg_fingers = left_leg.addOrReplaceChild("left_leg_fingers", CubeListBuilder.create().texOffs(40, 0).addBox(1.0F, 1.0F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 0).addBox(4.0F, 1.0F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 0).addBox(2.5F, 1.0F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 12.0F, 0.0F));

		PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(22, 39).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -12.0F, 0.0F));

		PartDefinition right_leg_fingers = right_leg.addOrReplaceChild("right_leg_fingers", CubeListBuilder.create().texOffs(40, 0).addBox(1.0F, 1.0F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 0).addBox(4.0F, 1.0F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 0).addBox(2.5F, 1.0F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Werellager entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch);

		this.animate(entity.idleAnimationState, WerellagerLycanAnimations.IDLE, ageInTicks);
		this.animate(entity.walkAnimationState, WerellagerLycanAnimations.WALK, ageInTicks);
		this.animate(entity.attackAnimationState, WerellagerLycanAnimations.ATTACK, ageInTicks);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
		float newNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		float newHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = newNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = newHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		werellager_lycan.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.werellager_lycan;
	}
}