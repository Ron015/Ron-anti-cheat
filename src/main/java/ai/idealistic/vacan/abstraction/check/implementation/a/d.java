package ai.idealistic.vacan.abstraction.check.implementation.a;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.Material;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class d extends ai.idealistic.vacan.abstraction.check.e {
   private final ai.idealistic.vacan.abstraction.check.b bV = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "auto_totem", true);
   private final ai.idealistic.vacan.abstraction.check.b bW = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "closed_inventory", true);
   private final ai.idealistic.vacan.abstraction.check.b bX = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "portal_inventory", true);
   private final ai.idealistic.vacan.abstraction.check.b bY = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "cursor_usage", true);
   private static final Material bZ = ai.idealistic.vacan.utils.minecraft.a.d.au("nether_portal");
   private static final Material ca;
   private static final double[] cb;
   private long cc;

   public d(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
   }

   protected void a(boolean var1, Object var2) {
      if (var2 instanceof PlayerDeathEvent) {
         this.F();
      } else if (var2 instanceof InventoryClickEvent) {
         InventoryClickEvent var3 = (InventoryClickEvent)var2;
         ItemStack var4 = var3.getCurrentItem();
         this.a(var3.getClick());
         this.b(var4);
         this.a(var4);
         if (this.j()) {
            var3.setCancelled(true);
         }
      } else if (var2 instanceof PlayerMoveEvent) {
         this.bY.a(() -> {
            if (!this.ac.cp() && this.ac.cg() == null) {
               ItemStack var1 = this.ac.bC().getOpenInventory().getCursor();
               if (ai.idealistic.vacan.utils.minecraft.world.c.h(var1)) {
                  int var2 = this.M();
                  if (var2 != 0) {
                     this.bY.a("cursor-usage, case: " + var2, this.ac.bM(), 0, false);
                  }
               }
            }

         });
      } else if (ai.idealistic.vacan.functionality.server.c.bW() && var2 instanceof PacketEvent) {
         PacketType var8 = ((PacketEvent)var2).getPacketType();
         PacketType[] var9 = ai.idealistic.vacan.listeners.protocol.d.jQ;
         int var5 = var9.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            PacketType var7 = var9[var6];
            if (var7.equals(var8)) {
               this.F();
               break;
            }
         }
      }

   }

   private void a(ItemStack var1) {
      this.bV.a(() -> {
         if (ca != null && var1 != null && var1.getType() == ca) {
            this.cc = System.currentTimeMillis() + 150L;
         }

      });
   }

   private void F() {
      long var1 = this.cc - System.currentTimeMillis();
      if (var1 > 0L) {
         this.bV.c("auto-totem, remaining-ticks: " + var1);
      }

   }

   private void a(ClickType var1) {
      this.bW.a(() -> {
         int var2 = this.M();
         if (var2 != 0 && !var1.isCreativeAction() && !var1.isKeyboardClick() && !this.ac.cp() && this.ac.cg() == null && this.ac.bC().getOpenInventory().countSlots() > 46 && !ai.idealistic.vacan.utils.minecraft.world.a.a(cb, this.ac.bO(), true, ai.idealistic.vacan.utils.minecraft.world.c.mB, ai.idealistic.vacan.utils.minecraft.world.c.mC)) {
            this.bW.c("closed-inventory, case: " + var2);
         }

      });
   }

   private void b(ItemStack var1) {
      this.bX.a(() -> {
         if (ai.idealistic.vacan.utils.minecraft.world.c.h(var1)) {
            ai.idealistic.vacan.abstraction.g.b var2 = new ai.idealistic.vacan.abstraction.g.b(this.ac.getLocation());
            if (var2.dO().dz() == bZ || var2.dC().d(0.0D, 1.0D, 0.0D).dO().dz() == bZ) {
               this.bX.c("portal-inventory");
            }
         }

      });
   }

   private int M() {
      if (!this.ac.cr() && !this.ac.bY()) {
         Check var1 = this.hackType.getCheck();
         return var1.a("check_sneaking", true) && this.ac.bL() ? 1 : (!MultiVersion.c(MultiVersion.MCVersion.V1_15) && var1.a("check_sprinting", true) && this.ac.bK() ? 2 : (var1.a("check_sleeping", true) && this.ac.bC().isSleeping() ? 3 : (var1.a("check_dead", true) && this.ac.bC().isDead() ? 5 : (var1.a("check_sprint_jumping", true) && this.ac.bK() && this.ac.s(this.N()) ? 6 : (var1.a("check_walk_jumping", true) && !this.ac.bK() && this.ac.s(this.N()) ? 7 : (var1.a("check_jumping", true) && this.ac.t(this.N()) ? 8 : 0))))));
      } else {
         return 0;
      }
   }

   private double N() {
      return this.ac.getLocation().getY() - this.ac.bM().getY();
   }

   static {
      ca = MultiVersion.c(MultiVersion.MCVersion.V1_11) ? Material.getMaterial("TOTEM_OF_UNDYING") : null;
      cb = new double[]{1.0D, -1.0D, 1.0D};
   }
}
