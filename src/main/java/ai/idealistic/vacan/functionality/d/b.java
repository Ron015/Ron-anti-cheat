package ai.idealistic.vacan.functionality.d;

import ai.idealistic.vacan.compatibility.Compatibility;
import java.util.Iterator;
import java.util.List;
import org.bukkit.entity.Entity;

public class b {
   public static boolean a(ai.idealistic.vacan.abstraction.f.c var0, boolean var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      if ((var2 || !var0.co()) && (var3 || !var0.cs()) && (var1 || var0.cg() == null) && (var4 || ai.idealistic.vacan.compatibility.a.f.a.e(var0, "GENERIC_MOVEMENT_SPEED") == Double.MIN_VALUE && ai.idealistic.vacan.compatibility.a.f.a.e(var0, "GENERIC_JUMP_STRENGTH") == Double.MIN_VALUE) && (var5 || ai.idealistic.vacan.compatibility.a.f.a.e(var0, "GENERIC_STEP_HEIGHT") == Double.MIN_VALUE && ai.idealistic.vacan.compatibility.a.f.a.e(var0, "GENERIC_GRAVITY") == Double.MIN_VALUE)) {
         if (Compatibility.CompatibilityType.MYTHIC_MOBS.isFunctional() || Compatibility.CompatibilityType.ITEMS_ADDER.isFunctional()) {
            List var6 = var0.b(6.0D, 6.0D, 6.0D);
            if (!var6.isEmpty()) {
               Iterator var7 = var6.iterator();

               while(var7.hasNext()) {
                  Entity var8 = (Entity)var7.next();
                  if (ai.idealistic.vacan.compatibility.a.b.b.c(var8) || ai.idealistic.vacan.compatibility.a.a.d.c(var8)) {
                     return false;
                  }
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }
}
