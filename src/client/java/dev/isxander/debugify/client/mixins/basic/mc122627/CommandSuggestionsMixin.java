package dev.isxander.debugify.client.mixins.basic.mc122627;

import dev.isxander.debugify.fixes.BugFix;
import dev.isxander.debugify.fixes.FixCategory;
import net.minecraft.client.gui.components.CommandSuggestions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@BugFix(id = "MC-122627", category = FixCategory.BASIC, env = BugFix.Env.CLIENT)
@Mixin(CommandSuggestions.class)
public class CommandSuggestionsMixin {
    /**
     * Minecraft renders the text at +1 on the x-axis
     * but does not compensate and add 1 to the width of the box
     */
    @ModifyArg(method = "renderUsage", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiComponent;fill(Lcom/mojang/blaze3d/vertex/PoseStack;IIIII)V"), index = 3)
    private int getX2(int x) {
        return x + 1;
    }
}
