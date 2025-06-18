package ai.idealistic.vacan.compatibility.a.a;

import ai.idealistic.vacan.compatibility.Compatibility;
import com.archyx.aureliumskills.api.event.TerraformBlockBreakEvent;
import java.util.LinkedHashMap;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class b implements Listener {
   private static final ai.idealistic.vacan.abstraction.b.c fN = new ai.idealistic.vacan.abstraction.b.c(new ai.idealistic.vacan.utils.a.c(new LinkedHashMap(), 512));

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(TerraformBlockBreakEvent var1) {
      if (Compatibility.CompatibilityType.AURELIUM_SKILLS.isEnabled()) {
         ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.i(var1.getPlayer());
         fN.g(var2.bT() + "=aureliumskills=compatibility", 20);
      }

   }

   public static boolean i(ai.idealistic.vacan.abstraction.f.c var0) {
      return Compatibility.CompatibilityType.AURELIUM_SKILLS.isFunctional() && !fN.t(var0.bT() + "=aureliumskills=compatibility");
   }
}
