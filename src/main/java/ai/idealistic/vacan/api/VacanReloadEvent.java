package ai.idealistic.vacan.api;

import ai.idealistic.vacan.Register;
import me.vagdedes.spartan.api.SpartanReloadEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;

public class VacanReloadEvent extends Event implements Cancellable {
   private boolean cancelled = false;
   private static final HandlerList handlers = new HandlerList();

   public VacanReloadEvent() {
      SpartanReloadEvent var1 = new SpartanReloadEvent();
      var1.setCancelled(this.isCancelled());
      Bukkit.getPluginManager().callEvent(var1);
   }

   public Plugin getPlugin() {
      return Register.plugin;
   }

   public boolean isCancelled() {
      return this.cancelled;
   }

   public void setCancelled(boolean var1) {
      this.cancelled = var1;
   }

   public HandlerList getHandlers() {
      return handlers;
   }

   public static HandlerList getHandlerList() {
      return handlers;
   }
}
