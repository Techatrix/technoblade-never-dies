package com.techatrix.technobladeneverdies.client;

import com.google.common.collect.ImmutableList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;
import net.minecraft.entity.Entity;

@Environment(value = EnvType.CLIENT)
public class PigEntityCrownModel<T extends Entity>
        extends AnimalModel<T> {
    protected final ModelPart head;

    public PigEntityCrownModel(ModelPart root) {
        super(false, 4.0f, 4.0f, 2.0f, 2.0f, 24);
        this.head = root.getChild(EntityModelPartNames.HEAD);
    }

    public static ModelData getModelData(int stanceWidth, Dilation dilation) {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-4.0f, -4.0f, -8.0f, 8.0f, 8.0f, 8.0f, dilation), ModelTransform.pivot(0.0f, 18 - stanceWidth, -6.0f));
        return modelData;
    }

    @Override
    protected Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of(this.head);
    }

    @Override
    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of();
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.head.pitch = headPitch * ((float) Math.PI / 180);
        this.head.yaw = headYaw * ((float) Math.PI / 180);
    }

    public static TexturedModelData getTexturedModelData(Dilation dilation) {
        ModelData modelData = getModelData(6, dilation);
        return TexturedModelData.of(modelData, 32, 16);
    }

}
