package ai.idealistic.vacan.abstraction.check.implementation.c;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.compatibility.Compatibility;
import ai.idealistic.vacan.compatibility.a.b.f;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class d extends ai.idealistic.vacan.abstraction.check.e {
   private final ai.idealistic.vacan.abstraction.check.b cm = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "breaking", true);
   private final ai.idealistic.vacan.abstraction.check.b bM = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "interact", true);

   public d(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
   }

   protected void a(boolean var1, Object var2) {
      if (var2 instanceof BlockBreakEvent) {
         this.cm.a(() -> {
            if (!Compatibility.CompatibilityType.ADVANCED_ENCHANTMENTS.isFunctional()) {
               BlockBreakEvent var2x = (BlockBreakEvent)var2;
               Block var3 = var2x.getBlock();
               if (this.a(var3) && !ai.idealistic.vacan.compatibility.a.a.d.e(var3)) {
                  long var4 = ai.idealistic.vacan.utils.minecraft.a.d.a(this.ac, this.ac.getItemInHand(), var3.getType());
                  if (var4 <= 500L) {
                     return;
                  }

                  Location var6 = this.ac.bO().clone().add(0.0D, this.ac.cn(), 0.0D);
                  double var7 = ai.idealistic.vacan.abstraction.g.b.b(var6, var3.getLocation());
                  ai.idealistic.vacan.abstraction.g.b var9 = this.ac.d(var7, 16.0D);
                  if (var9 != null) {
                     double var10 = var9.u(var6);
                     if (var10 < var7) {
                        this.cm.a("breaking, interacted-block: " + ai.idealistic.vacan.utils.minecraft.world.c.i(var3) + ", blocking-block: " + ai.idealistic.vacan.utils.minecraft.world.c.b(var9.dO()) + ", interacted-distance: " + var7 + ", blocking-distance: " + var10, (Location)null, 1);
                        if (this.cm.j()) {
                           var2x.setCancelled(true);
                        }
                     }
                  }
               }
            }

         });
      } else if (var2 instanceof PlayerInteractEvent) {
         this.bM.a(() -> {
            PlayerInteractEvent var2x = (PlayerInteractEvent)var2;
            if (var2x.getAction() == Action.RIGHT_CLICK_BLOCK) {
               Block var3 = var2x.getClickedBlock();
               if (var3 != null && this.a(var3) && ai.idealistic.vacan.utils.minecraft.world.c.U(var3.getType())) {
                  Location var4 = this.ac.bO().clone().add(0.0D, this.ac.cn(), 0.0D);
                  double var5 = ai.idealistic.vacan.abstraction.g.b.b(var4, var3.getLocation());
                  ai.idealistic.vacan.abstraction.g.b var7 = this.ac.d(var5, 16.0D);
                  if (var7 != null) {
                     double var8 = var7.u(var4);
                     if (var8 < var5) {
                        this.bM.a("interact, interacted-block: " + ai.idealistic.vacan.utils.minecraft.world.c.i(var3) + ", blocking-block: " + ai.idealistic.vacan.utils.minecraft.world.c.b(var7.dO()) + ", interacted-distance: " + var5 + ", blocking-distance: " + var8, (Location)null, 1);
                        if (this.bM.j()) {
                           var2x.setCancelled(true);
                        }
                     }
                  }
               }
            }

         });
      }

   }

   private boolean a(Block var1) {
      return var1.getWorld() == this.ac.bV() && !f.f(var1);
   }

   protected boolean m() {
      if (!this.ac.cr() && !Compatibility.CompatibilityType.MC_MMO.isFunctional() && !ai.idealistic.vacan.compatibility.a.e.b.d(this.ac, "drill") && !ai.idealistic.vacan.compatibility.a.b.c.i(this.ac) && ai.idealistic.vacan.compatibility.a.f.a.e(this.ac, "PLAYER_BLOCK_INTERACTION_RANGE") == Double.MIN_VALUE) {
         GameMode var1 = this.ac.cl();
         return var1 == GameMode.SURVIVAL || var1 == GameMode.ADVENTURE;
      } else {
         return false;
      }
   }
}
