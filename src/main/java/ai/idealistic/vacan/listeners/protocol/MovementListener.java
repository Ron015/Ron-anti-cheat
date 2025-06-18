package ai.idealistic.vacan.listeners.protocol;

import ai.idealistic.vacan.Register;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import java.util.Iterator;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementListener extends PacketAdapter {
   public MovementListener() {
      super(Register.plugin, ListenerPriority.LOWEST, new PacketType[]{Server.POSITION, Client.POSITION, Client.POSITION_LOOK, Client.LOOK, MultiVersion.c(MultiVersion.MCVersion.V1_17) ? Client.GROUND : Client.FLYING});
   }

   public void onPacketSending(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var2);
      Location var4 = ai.idealistic.vacan.utils.minecraft.b.a.a(var1);
      if (var4 != null) {
         if (!var1.getPacket().getFloat().getValues().isEmpty()) {
            var4.setYaw((Float)var1.getPacket().getFloat().read(0));
            var4.setPitch((Float)var1.getPacket().getFloat().read(1));
         }

         Location var5 = var3.getLocation().clone();
         Location var6 = var4.clone();
         Set var7 = ai.idealistic.vacan.utils.minecraft.b.a.c(var1);
         Iterator var8 = var7.iterator();

         while(var8.hasNext()) {
            MovementListener.tpFlags var9 = (MovementListener.tpFlags)var8.next();
            if (var9.equals(MovementListener.tpFlags.X)) {
               var6.setX(var5.getX() + var4.getX());
            }

            if (var9.equals(MovementListener.tpFlags.Y)) {
               var6.setY(var5.getY() + var4.getY());
            }

            if (var9.equals(MovementListener.tpFlags.Z)) {
               var6.setZ(var5.getZ() + var4.getZ());
            }
         }

         var3.n(var6.clone());
      }
   }

   public void onPacketReceiving(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var2);
      PacketContainer var4 = var1.getPacket();
      if (!var3.bX()) {
         Location var5 = var3.getLocation();
         var3.p(var5.clone());
         boolean var6 = ai.idealistic.vacan.utils.minecraft.b.a.b(var1);
         var3.u(var6);
         Location var7 = ai.idealistic.vacan.utils.minecraft.b.a.a(var1);
         if (var7 != null) {
            Location var8 = ai.idealistic.vacan.utils.minecraft.b.a.a(var1);
            if (var8 != null) {
               if (ai.idealistic.vacan.utils.minecraft.b.a.b(var1.getPacket().getType())) {
                  var8.setYaw((Float)var1.getPacket().getFloat().read(0));
                  var8.setPitch((Float)var1.getPacket().getFloat().read(1));
               }

               double[] var9 = new double[]{var8.getX(), var8.getY(), var8.getZ(), (double)var8.getYaw(), (double)var8.getPitch()};
               double[] var10 = var9;
               int var11 = var9.length;

               for(int var12 = 0; var12 < var11; ++var12) {
                  Double var13 = var10[var12];
                  if (var13.isNaN() || var13.isInfinite() || Math.abs(var13) > 3.0E8D) {
                     ai.idealistic.vacan.functionality.server.c.i(var2).gj.a((CommandSender)Bukkit.getConsoleSender(), "Invalid packet");
                     return;
                  }
               }

               boolean var17 = ai.idealistic.vacan.utils.minecraft.b.a.a(var1, var5, var7);
               ai.idealistic.vacan.abstraction.d.g var18 = (new ai.idealistic.vacan.abstraction.d.g(var3, var17, var6)).bq();
               ai.idealistic.vacan.listeners.a.c.a(var18);
               if (var18.G() > 65L) {
                  var3.gR = var18.G();
               } else if (var18.G() > 10L && var3.gR != 0L) {
                  var3.gR = 0L;
               }

               if (var3.bF() && var18.G() > 40L && var18.G() < 60L) {
                  var3.gm += var3.bG() ? 2 : 1;
                  if (var3.gm > 40) {
                     ai.idealistic.vacan.functionality.c.a.N(var2.getName() + " moves faster than the transaction response (" + var18.G() + "ms > " + (System.currentTimeMillis() - var3.gO) + "ms).");
                  }
               } else if (var3.gm > 0) {
                  var3.gm -= 2;
               }

               if (var3.gt) {
                  i.D(var3);
               }

               if (!ai.idealistic.vacan.compatibility.b.a.b.i(var2).getName().equals(var3.gA)) {
                  var3.gA = ai.idealistic.vacan.compatibility.b.a.b.i(var2).getName();
                  var3.o(ai.idealistic.vacan.utils.minecraft.b.a.k(var2));
               }

               if (!var17) {
                  boolean var19 = ai.idealistic.vacan.utils.minecraft.b.a.a(var4.getType());
                  boolean var20 = ai.idealistic.vacan.utils.minecraft.b.a.b(var4.getType());
                  if (var19) {
                     var3.m(var7);
                  }

                  if (ai.idealistic.vacan.utils.minecraft.b.a.v(var3.getLocation())) {
                     var3.o(var7);
                     var3.p(var7);
                  } else {
                     if (var19) {
                        Location var14 = var3.dq();
                        if (var14 != null) {
                           if (var14.getX() != var7.getX() || var14.getY() != var7.getY() || var14.getZ() != var7.getZ()) {
                              Iterator var15 = var3.u(5.0D).iterator();

                              Entity var16;
                              do {
                                 if (!var15.hasNext()) {
                                    var1.setCancelled(true);
                                    Bukkit.getScheduler().runTask(Register.plugin, () -> {
                                       Location var1 = var3.dq();
                                       if (var1 != null) {
                                          Location var2 = var1.clone();
                                          var2.setYaw(var3.getLocation().getYaw());
                                          var2.setPitch(var3.getLocation().getPitch());
                                          var3.l(var2);
                                       }

                                    });
                                    return;
                                 }

                                 var16 = (Entity)var15.next();
                              } while(!(var16 instanceof Boat));

                              return;
                           }

                           var3.o(var14.clone());
                           var3.p(var14.clone());
                           var3.n((Location)null);
                        } else {
                           var5.setX(var7.getX());
                           var5.setY(var7.getY());
                           var5.setZ(var7.getZ());
                        }
                     }

                     if (var20) {
                        var5.setYaw((Float)var4.getFloat().read(0));
                        var5.setPitch((Float)var4.getFloat().read(1));
                     }
                  }

                  if (var3.gw) {
                     if (MultiVersion.c(MultiVersion.MCVersion.V1_9)) {
                        if (!var3.cd().getItemInMainHand().getType().isEdible() && !var3.cd().getItemInOffHand().getType().isEdible()) {
                           var3.gw = false;
                        }
                     } else if (!var3.cd().getItemInHand().getType().isEdible()) {
                        var3.gw = false;
                     }

                     if (var2.getFoodLevel() == 20 || var3.gx) {
                        var3.gw = false;
                     }
                  }

                  ai.idealistic.vacan.functionality.b.a.b(() -> {
                     PlayerMoveEvent var3x = new PlayerMoveEvent(var2, var3.bM(), var3.getLocation());
                     var3x.setCancelled(var1.isCancelled());
                     var3.a(new ai.idealistic.vacan.abstraction.b.d(var3));
                     ai.idealistic.vacan.listeners.a.c.a(var3x, true);
                  });
                  if (var3.gn > 0) {
                     --var3.gn;
                  }
               } else {
                  var3.b(var1.isCancelled(), new ai.idealistic.vacan.abstraction.d.k(var3, var1));
               }

            }
         }
      }
   }

   public static enum tpFlags {
      X,
      Y,
      Z,
      Y_ROT,
      X_ROT;

      // $FF: synthetic method
      private static MovementListener.tpFlags[] $values() {
         return new MovementListener.tpFlags[]{X, Y, Z, Y_ROT, X_ROT};
      }
   }
}
