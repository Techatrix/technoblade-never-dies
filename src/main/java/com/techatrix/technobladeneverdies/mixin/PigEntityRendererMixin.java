package com.techatrix.technobladeneverdies.mixin;

import com.techatrix.technobladeneverdies.client.CrownFeatureRenderer;
import com.techatrix.technobladeneverdies.client.PigEntityCrownModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.PigEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PigEntityRenderer.class)
public abstract class PigEntityRendererMixin extends MobEntityRenderer<PigEntity, PigEntityModel<PigEntity>> {
    private static final EntityModelLayer PIG_HAT_LAYER = new EntityModelLayer(new Identifier("minecraft", "pig"), "hat");

    public PigEntityRendererMixin(EntityRendererFactory.Context context, PigEntityModel<PigEntity> entityModel, float f) {
        super(context, entityModel, f);
    }

    @Inject(at = @At("RETURN"), method = "<init>")
    private void init(EntityRendererFactory.Context context, CallbackInfo info) {
        this.addFeature(new CrownFeatureRenderer(this, new PigEntityCrownModel(context.getPart(PIG_HAT_LAYER)), new Identifier("textures/entity/pig/pig_hat.png")));
    }

}

