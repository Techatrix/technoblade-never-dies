package com.techatrix.technobladeneverdies.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class TechnobladeNeverDiesClient implements ClientModInitializer {
    private static final EntityModelLayer PIG_HAT_LAYER = new EntityModelLayer(new Identifier("minecraft", "pig"), "hat");

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(PIG_HAT_LAYER, () -> PigEntityCrownModel.getTexturedModelData(new Dilation(0.5F)));
    }

}
