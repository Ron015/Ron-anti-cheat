package ai.idealistic.vacan.abstraction.check.implementation.combat;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.PlayerInventory;

public class b extends ai.idealistic.vacan.abstraction.check.e {
   private final ai.idealistic.vacan.abstraction.check.b ak = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "bow_force", true, 2000L, 30000L, 40000L, 60000L);
   private final ai.idealistic.vacan.abstraction.check.b al = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "bow_shots", true, 2000L, 30000L, 40000L, 60000L);
   private long am;
   private final ai.idealistic.vacan.abstraction.b.a.a an = new ai.idealistic.vacan.abstraction.b.a.a();
   private final ai.idealistic.vacan.abstraction.b.a.a ao = new ai.idealistic.vacan.abstraction.b.a.a();

   public b(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
   }

   protected void a(boolean var1, Object var2) {
      if (var2 instanceof EntityShootBowEvent) {
         EntityShootBowEvent var3 = (EntityShootBowEvent)var2;
         if (this.ac.getItemInHand().getType() == Material.BOW) {
            this.b(var3);
            this.a(var3);
         }
      } else if (var2 instanceof PlayerInteractEvent) {
         PlayerInteractEvent var5 = (PlayerInteractEvent)var2;
         if (var5.getAction() == Action.RIGHT_CLICK_AIR) {
            PlayerInventory var4 = this.ac.cd();
            if (var4.getItemInHand().getType() == Material.BOW && var4.contains(Material.ARROW)) {
               this.am = System.currentTimeMillis();
            }
         }
      }

   }

   private void a(EntityShootBowEvent var1) {
      this.ak.a(() -> {
         if (var1.getForce() == 1.0F) {
            long var2 = System.currentTimeMillis() - this.am;
            if (var2 <= 500L) {
               double var4 = this.an.a(1.0D, 20);
               double var6 = 2.0D;
               if (var4 >= var6) {
                  this.an.aO();
                  this.ak.c("bow-force, ms: " + var2);
                  if (this.j()) {
                     var1.setCancelled(true);
                  }
               }

            }
         }
      });
   }

   private void b(EntityShootBowEvent var1) {
      this.al.a(() -> {
         double var2 = this.ao.a(1.0D, 10);
         double var4 = 7.0D;
         if (var2 >= var4) {
            this.al.c("bow-shots");
            if (this.j()) {
               var1.setCancelled(true);
            }
         }

      });
   }
}
