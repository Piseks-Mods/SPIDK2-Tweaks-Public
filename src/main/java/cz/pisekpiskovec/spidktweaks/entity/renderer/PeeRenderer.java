
package cz.pisekpiskovec.spidktweaks.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import cz.pisekpiskovec.spidktweaks.entity.PeeEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class PeeRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(PeeEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelpee(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("piseks_spidk_ii_tweaks:textures/entities/pee.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.10.4
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelpee extends EntityModel<Entity> {
		private final ModelRenderer left_wing;
		private final ModelRenderer right_wing;
		private final ModelRenderer front_legs;
		private final ModelRenderer middle_legs;
		private final ModelRenderer back_legs;
		private final ModelRenderer torso;

		public Modelpee() {
			textureWidth = 64;
			textureHeight = 64;
			left_wing = new ModelRenderer(this);
			left_wing.setRotationPoint(1.5F, 15.0F, -3.0F);
			left_wing.setTextureOffset(18, 0).addBox(0.2F, 0.0F, 0.0F, 9.0F, 0.0F, 6.0F, 0.0F, false);
			right_wing = new ModelRenderer(this);
			right_wing.setRotationPoint(-1.5F, 15.0F, -3.0F);
			right_wing.setTextureOffset(0, 17).addBox(-8.8F, 0.0F, 0.0F, 9.0F, 0.0F, 6.0F, 0.0F, false);
			front_legs = new ModelRenderer(this);
			front_legs.setRotationPoint(1.5F, 22.0F, -2.0F);
			front_legs.setTextureOffset(0, 17).addBox(-2.8F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, 0.0F, false);
			middle_legs = new ModelRenderer(this);
			middle_legs.setRotationPoint(1.5F, 22.0F, 0.0F);
			middle_legs.setTextureOffset(10, 23).addBox(-3.8F, 0.0F, 0.0F, 5.0F, 2.0F, 0.0F, 0.0F, false);
			back_legs = new ModelRenderer(this);
			back_legs.setRotationPoint(1.5F, 22.0F, 2.0F);
			back_legs.setTextureOffset(0, 23).addBox(-3.8F, 0.0F, 0.0F, 5.0F, 2.0F, 0.0F, 0.0F, false);
			torso = new ModelRenderer(this);
			torso.setRotationPoint(0.0F, 19.0F, 0.0F);
			torso.setTextureOffset(0, 0).addBox(-3.3F, -4.0F, -5.0F, 7.0F, 7.0F, 10.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			left_wing.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			right_wing.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			front_legs.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			middle_legs.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			back_legs.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			torso.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.right_wing.rotateAngleY = f2 / 20.f;
			this.left_wing.rotateAngleY = f2 / 20.f;
		}
	}

}
