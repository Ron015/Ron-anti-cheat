package ai.idealistic.vacan.abstraction.check.implementation.a;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;
import org.bukkit.potion.PotionEffectType;

public class c extends ai.idealistic.vacan.abstraction.check.e {
   private final ai.idealistic.vacan.abstraction.check.b aj = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, (String)null, true);
   private double bU;
   private long bw;
   private final ai.idealistic.vacan.abstraction.b.a.a bk = new ai.idealistic.vacan.abstraction.b.a.a();

   public c(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
   }

   private long L() {
      int var1 = ai.idealistic.vacan.utils.minecraft.entity.d.a(this.ac, PotionEffectType.REGENERATION);
      long var2 = 0L;
      if (var1 > -1) {
         if (var1 <= 10) {
            var2 = var1 == 0 ? 300L : 45L;
         }
      } else {
         var2 = !MultiVersion.c(MultiVersion.MCVersion.V1_9) ? 3700L : 450L;
      }

      return var2;
   }

   protected void a(boolean var1, Object var2) {
      if (var2 instanceof EntityRegainHealthEvent) {
         this.aj.a(() -> {
            EntityRegainHealthEvent var2x = (EntityRegainHealthEvent)var2;
            RegainReason var3 = var2x.getRegainReason();
            if (var3 != RegainReason.CUSTOM && var3 != RegainReason.MAGIC) {
               double var4 = this.ac.ch();
               long var6 = System.currentTimeMillis() - this.bw;
               this.bw = System.currentTimeMillis();
               if (this.bU != var4) {
                  long var8 = this.L();
                  if (var8 > 0L && var6 < var8 && this.bk.a(1.0D, 10) == 3.0D) {
                     this.bk.aO();
                     this.aj.c("default, ms: " + var6 + ", limit: " + var8);
                     if (this.j()) {
                        var2x.setCancelled(true);
                     }
                  }
               }

               this.bU = var4;
            }

         });
      } else if (var2 instanceof FoodLevelChangeEvent && ((FoodLevelChangeEvent)var2).getFoodLevel() > this.ac.bC().getFoodLevel() && (!MultiVersion.c(MultiVersion.MCVersion.V1_13) || this.ac.getItemInHand().getType() != Material.DRIED_KELP)) {
         this.ac.a(this.hackType).a((String)null, (String)null, 10);
      }

   }

   protected boolean m() {
      if (this.ac.bV().getDifficulty() != Difficulty.PEACEFUL && this.ac.bC().getFireTicks() <= 0 && ai.idealistic.vacan.compatibility.a.f.a.e(this.ac, "GENERIC_MAX_ABSORPTION") == Double.MIN_VALUE) {
         GameMode var1 = this.ac.cl();
         return var1 == GameMode.ADVENTURE || var1 == GameMode.SURVIVAL;
      } else {
         return false;
      }
   }
}
