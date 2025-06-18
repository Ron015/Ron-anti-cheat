package ai.idealistic.vacan.abstraction.check.implementation.a;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class e extends ai.idealistic.vacan.abstraction.check.e {
   private final ai.idealistic.vacan.abstraction.check.b cd;
   private final ai.idealistic.vacan.abstraction.check.b ce;
   private final ai.idealistic.vacan.abstraction.check.b cf;
   private final ai.idealistic.vacan.abstraction.check.b cg;
   private long bw;
   private int ch;
   private final ai.idealistic.vacan.abstraction.b.a.a ci;
   private final ai.idealistic.vacan.abstraction.b.a.a cj;
   private final ai.idealistic.vacan.abstraction.b.a.a ck;
   private final ai.idealistic.vacan.abstraction.b.a.a cl;

   public e(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
      this.cd = new ai.idealistic.vacan.abstraction.check.a.a(this, Check.DataType.JAVA, (Check.DetectionType)null, "shift", true);
      this.ce = new ai.idealistic.vacan.abstraction.check.a.a(this, Check.DataType.JAVA, (Check.DetectionType)null, "slow", true);
      this.cf = new ai.idealistic.vacan.abstraction.check.a.a(this, Check.DataType.JAVA, (Check.DetectionType)null, "medium", true);
      this.cg = new ai.idealistic.vacan.abstraction.check.a.a(this, Check.DataType.JAVA, (Check.DetectionType)null, "fast", true);
      this.ci = new ai.idealistic.vacan.abstraction.b.a.a();
      this.cj = new ai.idealistic.vacan.abstraction.b.a.a();
      this.ck = new ai.idealistic.vacan.abstraction.b.a.a();
      this.cl = new ai.idealistic.vacan.abstraction.b.a.a();
   }

   protected void a(boolean var1, Object var2) {
      if (var2 instanceof InventoryClickEvent && (this.cd.i() || this.ce.i() || this.cf.i() || this.cg.i())) {
         InventoryClickEvent var3 = (InventoryClickEvent)var2;
         ItemStack var4 = var3.getCurrentItem();
         ClickType var5 = var3.getClick();
         if (!var5.isCreativeAction() && !var5.isKeyboardClick() && var4 != null && var4.getItemMeta() != null) {
            Material var6 = var4.getType();
            if (!ai.idealistic.vacan.utils.minecraft.world.c.a(this.ac, var6)) {
               boolean var7 = this.ac.bC().getOpenInventory().countSlots() <= 46;
               boolean var8 = var5.isShiftClick();
               String var9 = ai.idealistic.vacan.utils.minecraft.world.c.ae(var6);
               int var10 = var9.hashCode();
               int var11 = this.ch;
               this.ch = var10;
               if (var8 && !var7 && !ai.idealistic.vacan.utils.minecraft.world.c.h(this.ac.bC().getOpenInventory().getCursor()) && this.cl.a(1.0D, 5) == 4.0D) {
                  this.cl.aO();
                  this.cd.a(() -> {
                     this.cd.c("shift, item: " + var9);
                  });
               } else {
                  long var12 = System.currentTimeMillis() - this.bw;
                  this.bw = System.currentTimeMillis();
                  if ((!var8 && !var7 || var10 != var11) && var12 < 150L) {
                     this.ce.a(() -> {
                        if (this.ci.a(1.0D, 10) >= 8.0D) {
                           this.ce.c("slow, ms: " + var12 + ", item: " + var9);
                        }

                     });
                     if (var12 < 100L) {
                        this.cf.a(() -> {
                           if (this.cj.a(1.0D, 5) >= 4.0D) {
                              this.cf.c("medium, ms: " + var12 + ", item: " + var9);
                           }

                        });
                        this.cg.a(() -> {
                           if (var12 < 50L && this.ck.a(1.0D, 5) >= 4.0D) {
                              this.cg.c("fast, ms: " + var12 + ", item: " + var9);
                           }

                        });
                     }
                  }
               }
            }
         }

         if (this.j()) {
            var3.setCancelled(true);
         }
      }

   }
}
