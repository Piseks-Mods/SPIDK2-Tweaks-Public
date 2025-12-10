
package cz.pisekpiskovec.spidktweaks.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import cz.pisekpiskovec.spidktweaks.entity.HamsterWhiteEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class HamsterWhiteRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(HamsterWhiteEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelhamster(), 0.3f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("piseks_spidk_ii_tweaks:textures/entities/hamster_white.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.11.1
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelhamster extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer front_left_leg;
		private final ModelRenderer front_right_leg;
		private final ModelRenderer back_left_leg;
		private final ModelRenderer back_right_leg;
		private final ModelRenderer head;

		public Modelhamster() {
			textureWidth = 32;
			textureHeight = 32;
			body = new ModelRenderer(this);
			body.setRotationPoint(-0.025F, 20.8F, 2.3F);
			body.setTextureOffset(12, 18).addBox(-1.025F, -1.1F, 0.85F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addBox(-2.475F, -0.9F, -3.85F, 5.0F, 3.0F, 5.0F, 0.0F, false);
			front_left_leg = new ModelRenderer(this);
			front_left_leg.setRotationPoint(1.4F, 22.0F, -0.35F);
			front_left_leg.setTextureOffset(18, 8).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			front_right_leg = new ModelRenderer(this);
			front_right_leg.setRotationPoint(-1.4F, 22.0F, -0.35F);
			front_right_leg.setTextureOffset(18, 8).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			back_left_leg = new ModelRenderer(this);
			back_left_leg.setRotationPoint(1.4F, 22.0F, 2.25F);
			back_left_leg.setTextureOffset(18, 8).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			back_right_leg = new ModelRenderer(this);
			back_right_leg.setRotationPoint(-1.4F, 22.0F, 2.25F);
			back_right_leg.setTextureOffset(18, 8).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 19.9F, -1.45F);
			head.setTextureOffset(0, 12).addBox(-2.5F, -2.0F, -2.0F, 5.0F, 2.0F, 3.0F, 0.0F, false);
			head.setTextureOffset(0, 8).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(16, 12).addBox(-1.5F, 0.0F, -2.7F, 3.0F, 2.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(18, 18).addBox(-3.2F, -2.4F, -0.6F, 2.0F, 2.0F, 0.0F, 0.0F, false);
			head.setTextureOffset(0, 20).addBox(1.2F, -2.4F, -0.6F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			front_left_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			front_right_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			back_left_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			back_right_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.front_right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.back_right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.back_left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.front_left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}

}
