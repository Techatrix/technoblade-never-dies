package com.techatrix.technobladeneverdies.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

@Environment(value = EnvType.CLIENT)
public class CrownFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>>
        extends FeatureRenderer<T, M> {
    private final Identifier TEXTURE;
    private final M model;

    public CrownFeatureRenderer(FeatureRendererContext<T, M> context, M model, Identifier texture) {
        super(context);
        this.model = model;
        this.TEXTURE = texture;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if (!shouldRenderFeature(entity)) return;
        super.render(this.getContextModel(), this.model, this.TEXTURE, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, entity.age, headYaw, headPitch, tickDelta, 1.0f, 1.0f, 1.0f);
    }

    private static boolean shouldRenderFeature(Entity entity) {
        if (!(entity instanceof PigEntity)) return false;
        String string = Formatting.strip(entity.getName().getString());
        return (entity.hasCustomName() && "Technoblade".equals(string));
    }

}