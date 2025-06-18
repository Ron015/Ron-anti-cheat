package ai.idealistic.vacan.abstraction.check.implementation.combat.killaura;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import org.bukkit.GameRule;
import org.bukkit.inventory.InventoryView;

public class c extends ai.idealistic.vacan.abstraction.check.b {
   c(ai.idealistic.vacan.abstraction.check.e var1) {
      super(var1, (Check.DataType)null, (Check.DetectionType)null, "irregular", true, 1L, 1L, 1L, 1L);
   }

   void run() {
      this.a(() -> {
         if (this.ac.bC().isDead()) {
            if (!ai.idealistic.vacan.utils.minecraft.c.b.ay("respawn") && (!MultiVersion.c(MultiVersion.MCVersion.V1_15) || !(Boolean)this.ac.bV().getGameRuleValue(GameRule.DO_IMMEDIATE_RESPAWN))) {
               this.c("irregular, scenario: death");
            }
         } else if (this.ac.bC().isSleeping()) {
            this.c("irregular, scenario: sleeping");
         } else {
            InventoryView var1 = this.ac.bC().getOpenInventory();
            if (ai.idealistic.vacan.utils.minecraft.world.c.h(var1.getCursor())) {
               this.c("irregular, scenario: cursor");
            } else if (var1.countSlots() > 46) {
               this.c("irregular, scenario: inventory");
            }
         }

      });
   }
}
