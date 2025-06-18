package ai.idealistic.vacan.compatibility.a.b;

import ai.idealistic.vacan.compatibility.Compatibility;
import org.bukkit.block.Block;

public class f {
   public static boolean f(Block var0) {
      return Compatibility.CompatibilityType.TREE_FELLER.isFunctional() && ai.idealistic.vacan.utils.minecraft.world.c.T(var0.getType());
   }
}
