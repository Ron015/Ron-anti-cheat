package ai.idealistic.vacan.api;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import lombok.Generated;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CheckCancelEvent extends Event implements Cancellable {
   private final Player p;
   private final CheckEnums.HackType h;
   private boolean cancelled;
   private static final HandlerList handlers = new HandlerList();

   public CheckCancelEvent(Player var1, CheckEnums.HackType var2) {
      this.p = var1;
      this.h = var2;
      this.cancelled = false;
      me.vagdedes.spartan.api.CheckCancelEvent var3 = new me.vagdedes.spartan.api.CheckCancelEvent(var1, var2);
      var3.setCancelled(this.isCancelled());
      Bukkit.getPluginManager().callEvent(var3);
   }

   public Player getPlayer() {
      return this.p;
   }

   public CheckEnums.HackType getHackType() {
      return this.h;
   }

   public HandlerList getHandlers() {
      return handlers;
   }

   public static HandlerList getHandlerList() {
      return handlers;
   }

   @Generated
   public void setCancelled(boolean var1) {
      this.cancelled = var1;
   }

   @Generated
   public boolean isCancelled() {
      return this.cancelled;
   }
}
