// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelowl extends EntityModel<Entity> {
	private final ModelRenderer legs;
	private final ModelRenderer right_leg;
	private final ModelRenderer left_leg;
	private final ModelRenderer body;
	private final ModelRenderer right_wing;
	private final ModelRenderer left_wing;
	private final ModelRenderer tail;
	private final ModelRenderer tail_left_r1;
	private final ModelRenderer top;
	private final ModelRenderer head;
	private final ModelRenderer neck;

	public Modelowl() {
		textureWidth = 64;
		textureHeight = 64;

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, 24.0F, 0.0F);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-1.0F, -2.0F, -0.5F);
		legs.addChild(right_leg);
		right_leg.setTextureOffset(30, 3).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		right_leg.setTextureOffset(6, 30).addBox(-1.0F, 2.0F, -1.5F, 2.0F, 0.0F, 1.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(2.0F, -2.0F, -0.5F);
		legs.addChild(left_leg);
		left_leg.setTextureOffset(26, 6).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		left_leg.setTextureOffset(0, 30).addBox(-1.0F, 2.0F, -1.5F, 2.0F, 0.0F, 1.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 1.4F);
		setRotationAngle(body, 0.1309F, 0.0F, 0.0F);
		body.setTextureOffset(0, 9).addBox(-2.5F, -8.0F, -3.3F, 6.0F, 6.0F, 5.0F, 0.0F, false);

		right_wing = new ModelRenderer(this);
		right_wing.setRotationPoint(-2.5F, -9.0F, -0.5F);
		body.addChild(right_wing);
		right_wing.setTextureOffset(22, 20).addBox(-1.0F, 0.0F, -2.5F, 1.0F, 6.0F, 5.0F, 0.0F, false);

		left_wing = new ModelRenderer(this);
		left_wing.setRotationPoint(3.5F, -9.0F, -0.5F);
		body.addChild(left_wing);
		left_wing.setTextureOffset(22, 9).addBox(0.0F, 0.0F, -2.5F, 1.0F, 6.0F, 5.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(-0.5F, -0.25F, 0.3F);
		body.addChild(tail);

		tail_left_r1 = new ModelRenderer(this);
		tail_left_r1.setRotationPoint(2.0F, 0.0F, 0.0F);
		tail.addChild(tail_left_r1);
		setRotationAngle(tail_left_r1, 0.2182F, 0.0F, 0.0F);
		tail_left_r1.setTextureOffset(0, 31).addBox(1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		tail_left_r1.setTextureOffset(8, 31).addBox(0.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		tail_left_r1.setTextureOffset(2, 31).addBox(-1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		tail_left_r1.setTextureOffset(4, 31).addBox(-2.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		tail_left_r1.setTextureOffset(6, 31).addBox(-3.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		tail_left_r1.setTextureOffset(20, 30).addBox(-4.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		top = new ModelRenderer(this);
		top.setRotationPoint(0.5F, 13.7667F, -1.3F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.6333F, 1.0F);
		top.addChild(head);
		head.setTextureOffset(26, 3).addBox(-0.5F, -1.6F, -3.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 20).addBox(-3.0F, -5.0F, -2.5F, 6.0F, 5.0F, 5.0F, 0.0F, false);
		head.setTextureOffset(26, 0).addBox(-3.0F, -4.5F, -2.7F, 6.0F, 2.0F, 0.0F, 0.0F, false);
		head.setTextureOffset(12, 30).addBox(2.0F, -5.5F, -2.6F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		head.setTextureOffset(30, 6).addBox(-4.0F, -5.5F, -2.6F, 2.0F, 2.0F, 0.0F, 0.0F, false);

		neck = new ModelRenderer(this);
		neck.setRotationPoint(-2.5F, 3.3333F, 3.0F);
		top.addChild(neck);
		neck.setTextureOffset(0, 0).addBox(-1.0F, -3.0F, -5.0F, 7.0F, 3.0F, 6.0F, 0.0F, false);
		neck.setTextureOffset(26, 2).addBox(0.0F, 0.0F, -5.0F, 5.0F, 1.0F, 0.0F, 0.0F, false);
		neck.setTextureOffset(16, 30).addBox(0.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		neck.setTextureOffset(30, 8).addBox(3.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		legs.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		top.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.right_wing.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.left_wing.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
	}
}