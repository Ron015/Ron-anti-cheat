package ai.idealistic.vacan.abstraction.check.implementation.a;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.compatibility.Compatibility;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class f extends ai.idealistic.vacan.abstraction.check.e {
   private final ai.idealistic.vacan.abstraction.check.b cm = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "breaking", true);
   private final ai.idealistic.vacan.abstraction.check.b cn = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "damage", true);
   private static final int co = 600;
   private long cp = Long.MAX_VALUE;
   private long cq = Long.MAX_VALUE;
   private final ai.idealistic.vacan.abstraction.b.a.a cr = new ai.idealistic.vacan.abstraction.b.a.a();
   private long cs;

   public f(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
   }

   protected void a(boolean var1, Object var2) {
      if (var2 instanceof PlayerInteractEvent) {
         PlayerInteractEvent var3 = (PlayerInteractEvent)var2;
         if (var3.getAction() == Action.LEFT_CLICK_BLOCK) {
            Block var4 = var3.getClickedBlock();
            if (var4 == null || !ai.idealistic.vacan.compatibility.a.a.d.e(var4)) {
               this.cp = System.currentTimeMillis();
            }
         }
      } else if (var2 instanceof PlayerAnimationEvent) {
         this.cq = System.currentTimeMillis();
      } else if (var2 instanceof BlockBreakEvent) {
         this.cm.a(() -> {
            if (!ai.idealistic.vacan.compatibility.a.b.a.i(this.ac) && !ai.idealistic.vacan.compatibility.a.a.b.i(this.ac)) {
               BlockBreakEvent var2x = (BlockBreakEvent)var2;
               Block var3 = var2x.getBlock();
               if (!ai.idealistic.vacan.utils.minecraft.world.c.a(this.ac, var3.getType()) && !ai.idealistic.vacan.compatibility.a.b.f.f(var3) && !ai.idealistic.vacan.compatibility.a.a.d.e(var3) && System.currentTimeMillis() - this.cp > 50L) {
                  if (this.cq == Long.MAX_VALUE) {
                     this.cm.c("breaking, block: " + ai.idealistic.vacan.utils.minecraft.world.c.i(var3) + ", item: " + ai.idealistic.vacan.utils.minecraft.world.c.ae(this.ac.getItemInHand().getType()));
                     if (this.cm.j()) {
                        var2x.setCancelled(true);
                     }
                  } else {
                     this.O();
                  }
               }

            }
         });
      } else if (var2 instanceof ai.idealistic.vacan.abstraction.d.e) {
         this.cn.a(() -> {
            if (this.ac.cf() == 1.0F) {
               LivingEntity var2x = ((ai.idealistic.vacan.abstraction.d.e)var2).fz;
               if (ai.idealistic.vacan.utils.minecraft.entity.b.b(this.ac, var2x)) {
                  long var3 = System.currentTimeMillis();
                  if (this.cs < var3) {
                     this.cs = var3 + 1000L;
                     if (this.cq == Long.MAX_VALUE) {
                        if (this.cr.a(1.0D, 600) >= 3.0D) {
                           this.cr.aO();
                           this.cn.c("damage, entity: " + ai.idealistic.vacan.utils.minecraft.entity.b.k(var2x) + ", item: " + ai.idealistic.vacan.utils.minecraft.world.c.ae(this.ac.getItemInHand().getType()));
                        }
                     } else {
                        this.O();
                     }
                  }

               }
            }
         });
      }

   }

   private void O() {
      this.cq = Long.MAX_VALUE;
   }

   public boolean m() {
      return !ai.idealistic.vacan.compatibility.a.e.b.d(this.ac, "drill") && !Compatibility.CompatibilityType.ADVANCED_ENCHANTMENTS.isFunctional();
   }
}
