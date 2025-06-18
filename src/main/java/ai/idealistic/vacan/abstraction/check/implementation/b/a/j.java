package ai.idealistic.vacan.abstraction.check.implementation.b.a;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.abstraction.d.k;
import ai.idealistic.vacan.listeners.protocol.l;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class j extends ai.idealistic.vacan.abstraction.check.e {
   private final g dW = new g(this);
   private final h dX = new h(this);
   private final b dY = new b(this);
   private final a dZ = new a(this);
   private final d ea = new d(this);
   private final c eb = new c(this);
   private final f ec = new f(this);
   private final i ed = new i(this);
   private final e ee = new e(this);

   public j(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
   }

   protected void a(boolean var1, Object var2) {
      if (var2 == null) {
         this.ee.run();
      } else if (var2 instanceof PlayerTeleportEvent) {
         this.P();
      } else if (var2 instanceof ai.idealistic.vacan.abstraction.d.b) {
         this.dW.ac();
         this.dX.ac();
      } else if (var2 instanceof k) {
         k var3 = (k)var2;
         this.dX.d((Boolean)var3.fF.getPacket().getBooleans().read(0));
         this.eb.a(new PlayerMoveEvent(var3.ac.bC(), var3.ac.getLocation(), var3.ac.bM()));
      } else if (var2 instanceof PlayerMoveEvent) {
         this.ee.V();
         this.dY.run();
         this.dZ.run();
         this.dW.run();
         this.dX.run();
         this.ea.run();
         this.ec.X();
         this.ed.run();
         this.eb.a((PlayerMoveEvent)var2);
      } else if (var2 instanceof BlockBreakEvent) {
         if (((BlockBreakEvent)var2).isCancelled()) {
            this.eb.R();
         } else {
            this.ee.R();
         }
      } else if (var2 instanceof VehicleExitEvent) {
         this.eb.S();
      } else if (var2 instanceof ai.idealistic.vacan.abstraction.d.g) {
         ai.idealistic.vacan.abstraction.d.g var8 = (ai.idealistic.vacan.abstraction.d.g)var2;
         this.dW.f(var8.fB);
      } else if (var2 instanceof VehicleEnterEvent) {
         this.dX.ab();
         this.dW.ab();
      } else if (ai.idealistic.vacan.utils.minecraft.entity.d.kX && var2 instanceof EntityToggleGlideEvent) {
         this.ec.W();
      } else if (ai.idealistic.vacan.functionality.server.c.bW() && var2 instanceof PacketEvent) {
         PacketType var9 = ((PacketEvent)var2).getPacketType();
         PacketType[] var4 = l.jQ;
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            PacketType var7 = var4[var6];
            if (var7.equals(var9)) {
               this.P();
               break;
            }
         }
      }

   }

   private void P() {
      this.dW.P();
      this.dX.P();
      this.dZ.P();
      this.ec.P();
      this.ed.P();
   }

   protected boolean m() {
      return ai.idealistic.vacan.functionality.d.b.a(this.ac, true, true, false, true, false);
   }
}
