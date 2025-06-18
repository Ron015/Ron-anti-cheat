package ai.idealistic.vacan.abstraction.check.implementation.a;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import org.bukkit.Difficulty;
import org.bukkit.Material;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffectType;

public class b extends ai.idealistic.vacan.abstraction.check.e {
   private final ai.idealistic.vacan.abstraction.check.b bM = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "interact", true);
   private final ai.idealistic.vacan.abstraction.check.b bN = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "eat", true);
   private static final Material bO = ai.idealistic.vacan.utils.minecraft.a.d.au("cake");
   private static final long bP = 1000L;
   private static final long bQ = 550L;
   private long bR;
   private long bS;

   public b(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
   }

   private long G() {
      if (MultiVersion.c(MultiVersion.MCVersion.V1_9)) {
         PlayerInventory var1 = this.ac.cd();
         ItemStack[] var2 = new ItemStack[]{var1.getItemInHand(), var1.getItemInOffHand()};
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            ItemStack var5 = var2[var4];
            if (var5 != null) {
               Material var6 = var5.getType();
               if (MultiVersion.c(MultiVersion.MCVersion.V1_13) && var6 == Material.DRIED_KELP) {
                  return 550L;
               }

               if (var6.isEdible()) {
                  return 1000L;
               }
            }
         }
      } else {
         ItemStack var7 = this.ac.getItemInHand();
         if (var7 != null) {
            Material var8 = var7.getType();
            if (var8.isEdible()) {
               return 1000L;
            }
         }
      }

      return 0L;
   }

   private void H() {
      this.bN.a(() -> {
         long var1 = System.currentTimeMillis() - this.bR;
         this.bR = System.currentTimeMillis();
         long var3 = this.G();
         if (var3 > 0L && var1 <= var3) {
            this.bN.c("eat, ms: " + var1);
         }

      });
   }

   private void I() {
      this.bM.a(() -> {
         long var1 = System.currentTimeMillis() - this.bS;
         long var3 = this.G();
         if (var3 > 0L && var1 <= var3) {
            this.bM.c("interact, ms: " + var1 + ", delay: " + var3);
         }

      });
   }

   protected void a(boolean var1, Object var2) {
      if (var2 instanceof FoodLevelChangeEvent) {
         FoodLevelChangeEvent var3 = (FoodLevelChangeEvent)var2;
         int var4 = var3.getFoodLevel();
         if (var4 > this.ac.bC().getFoodLevel()) {
            this.H();
            this.I();
            if (this.j()) {
               var3.setCancelled(true);
            }
         }
      } else if (var2 instanceof PlayerInteractEvent) {
         PlayerInteractEvent var5 = (PlayerInteractEvent)var2;
         switch(var5.getAction()) {
         case RIGHT_CLICK_BLOCK:
            if (var5.getClickedBlock().getType() == bO) {
               this.ac.a(this.hackType).a((String)null, (String)null, 10);
            }
            break;
         case RIGHT_CLICK_AIR:
            if (this.ac.getItemInHand().getType().isEdible()) {
               this.bS = System.currentTimeMillis();
            }
         }
      }

   }

   protected boolean m() {
      return this.ac.bV().getDifficulty() != Difficulty.PEACEFUL && !this.ac.b(PotionEffectType.SATURATION, 0L) && ai.idealistic.vacan.compatibility.a.f.a.e(this.ac, "GENERIC_MAX_ABSORPTION") == Double.MIN_VALUE;
   }
}
