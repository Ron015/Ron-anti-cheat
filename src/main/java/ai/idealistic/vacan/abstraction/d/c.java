package ai.idealistic.vacan.abstraction.d;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class c extends PlayerEvent implements Cancellable {
   private static final HandlerList handlers = new HandlerList();
   private boolean fx;
   private Vector aV;

   public c(@NotNull Player var1, @NotNull Vector var2) {
      if (var1 == null) {
         d(0);
      }

      if (var2 == null) {
         d(1);
      }

      super(var1);
      this.fx = false;
      this.aV = var2;
   }

   public boolean isCancelled() {
      return this.fx;
   }

   public void setCancelled(boolean var1) {
      this.fx = var1;
   }

   @NotNull
   public Vector bp() {
      Vector var10000 = this.aV;
      if (var10000 == null) {
         d(2);
      }

      return var10000;
   }

   public void a(@NotNull Vector var1) {
      if (var1 == null) {
         d(3);
      }

      this.aV = var1;
   }

   @NotNull
   public HandlerList getHandlers() {
      HandlerList var10000 = handlers;
      if (var10000 == null) {
         d(4);
      }

      return var10000;
   }

   @NotNull
   public static HandlerList getHandlerList() {
      HandlerList var10000 = handlers;
      if (var10000 == null) {
         d(5);
      }

      return var10000;
   }

   // $FF: synthetic method
   private static void d(int var0) {
      String var10000;
      switch(var0) {
      case 0:
      case 1:
      case 3:
      default:
         var10000 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
         break;
      case 2:
      case 4:
      case 5:
         var10000 = "@NotNull method %s.%s must not return null";
      }

      byte var10001;
      switch(var0) {
      case 0:
      case 1:
      case 3:
      default:
         var10001 = 3;
         break;
      case 2:
      case 4:
      case 5:
         var10001 = 2;
      }

      Object[] var2 = new Object[var10001];
      switch(var0) {
      case 0:
      default:
         var2[0] = "player";
         break;
      case 1:
      case 3:
         var2[0] = "velocity";
         break;
      case 2:
      case 4:
      case 5:
         var2[0] = "ai/idealistic/vacan/abstraction/event/CPlayerVelocityEvent";
      }

      switch(var0) {
      case 0:
      case 1:
      case 3:
      default:
         var2[1] = "ai/idealistic/vacan/abstraction/event/CPlayerVelocityEvent";
         break;
      case 2:
         var2[1] = "getVelocity";
         break;
      case 4:
         var2[1] = "getHandlers";
         break;
      case 5:
         var2[1] = "getHandlerList";
      }

      switch(var0) {
      case 0:
      case 1:
      default:
         var2[2] = "<init>";
      case 2:
      case 4:
      case 5:
         break;
      case 3:
         var2[2] = "setVelocity";
      }

      var10000 = String.format(var10000, var2);
      Object var1;
      String var4;
      switch(var0) {
      case 0:
      case 1:
      case 3:
      default:
         IllegalArgumentException var3 = new IllegalArgumentException;
         var4 = var10000;
         var1 = var3;
         var3.<init>(var4);
         break;
      case 2:
      case 4:
      case 5:
         IllegalStateException var10002 = new IllegalStateException;
         var4 = var10000;
         var1 = var10002;
         var10002.<init>(var4);
      }

      throw var1;
   }
}
