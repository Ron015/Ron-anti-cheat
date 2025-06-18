package ai.idealistic.vacan.abstraction.check.implementation.c.a;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.abstraction.check.e;
import ai.idealistic.vacan.compatibility.Compatibility;
import ai.idealistic.vacan.compatibility.a.a.d;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class a extends e {
   private final ai.idealistic.vacan.abstraction.check.b eq = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "scaffold_direction", true);
   private final ai.idealistic.vacan.abstraction.check.b er;
   private final ai.idealistic.vacan.abstraction.check.b es;
   private final ai.idealistic.vacan.abstraction.check.b et;
   private final c eu;
   private final b ev;

   public a(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
      this.er = new ai.idealistic.vacan.abstraction.check.a.a(this, Check.DataType.JAVA, (Check.DetectionType)null, "scaffold_up", true);
      this.es = new ai.idealistic.vacan.abstraction.check.a.a(this, Check.DataType.JAVA, (Check.DetectionType)null, "scaffold_yaw", true);
      this.et = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "actions", true);
      this.eu = new c(this);
      this.ev = new b(this);
   }

   protected void a(boolean var1, Object var2) {
      if (var2 instanceof ai.idealistic.vacan.abstraction.d.a) {
         ai.idealistic.vacan.abstraction.d.a var3 = (ai.idealistic.vacan.abstraction.d.a)var2;
         if (!d.e(var3.fu)) {
            Location var4 = this.ac.bO();
            int var5 = var4.getBlockY();
            int var6 = var3.fu.getY();
            this.ev.b(var3.fu);
            if (var6 < var5) {
               BlockFace var7 = var3.fv.getFace(var3.fu);
               if (var7 != null) {
                  switch(var7) {
                  case EAST:
                  case EAST_NORTH_EAST:
                  case EAST_SOUTH_EAST:
                  case WEST:
                  case WEST_NORTH_WEST:
                  case WEST_SOUTH_WEST:
                  case NORTH:
                  case NORTH_EAST:
                  case NORTH_NORTH_EAST:
                  case SOUTH:
                  case SOUTH_EAST:
                  case SOUTH_SOUTH_EAST:
                     if (this.eq.i() || this.er.i() || this.es.i()) {
                        double var8 = MultiVersion.c(MultiVersion.MCVersion.V1_9) ? this.a(var7).distance(var4.getDirection()) : Double.MAX_VALUE;
                        if (var8 <= 1.25D) {
                           this.eq.a(() -> {
                              this.eq.c("scaffold(direction), vector-distance: " + var8 + ", block-distance: " + ai.idealistic.vacan.abstraction.g.b.b(var4, var3.fv.getLocation()));
                           });
                        } else {
                           float var10 = var4.getPitch();
                           if ((double)var10 <= 0.0D) {
                              this.er.a(() -> {
                                 this.er.c("scaffold(up), pitch: " + var10 + ", block-distance: " + ai.idealistic.vacan.abstraction.g.b.b(var4, var3.fv.getLocation()));
                              });
                           } else {
                              this.es.a(() -> {
                                 List var3x = this.ac.bP();
                                 byte var4x = 5;
                                 int var5 = var4x + 1;
                                 if (var3x.size() >= var5) {
                                    var3x = var3x.subList(var3x.size() - var5, var3x.size());
                                    Iterator var6 = var3x.iterator();
                                    if (!var6.hasNext()) {
                                       return;
                                    }

                                    Entry var7 = (Entry)var6.next();

                                    double var8;
                                    Entry var10;
                                    for(var8 = 0.0D; var6.hasNext(); var7 = var10) {
                                       var10 = (Entry)var6.next();
                                       long var11 = System.currentTimeMillis() - (Long)var10.getKey();
                                       if (var11 > (long)(var4x * 2) * 50L) {
                                          return;
                                       }

                                       double var13 = (double)((((Location)var7.getValue()).getYaw() - ((Location)var10.getValue()).getYaw()) % 360.0F);
                                       var8 += var13 * var13;
                                    }

                                    var8 = Math.sqrt(var8 / (double)var4x);
                                    if (var8 >= 270.0D) {
                                       this.es.c("scaffold(yaw), deviation: " + var8 + ", block-distance: " + ai.idealistic.vacan.abstraction.g.b.b(var4, var3.fv.getLocation()));
                                    }
                                 }

                              });
                           }
                        }
                     }
                     break;
                  case UP:
                     this.eu.a(var3.fu, var4, var5, var6);
                  }
               }
            }
         }
      } else if (var2 instanceof PlayerInteractEvent) {
         this.et.a(() -> {
            PlayerInteractEvent var2x = (PlayerInteractEvent)var2;
            Action var3 = var2x.getAction();
            if ((var3 == Action.LEFT_CLICK_AIR || var3 == Action.LEFT_CLICK_BLOCK || var3 == Action.RIGHT_CLICK_AIR || var3 == Action.RIGHT_CLICK_BLOCK) && !Compatibility.CompatibilityType.MC_MMO.isFunctional()) {
               byte var4;
               if (this.ac.bC().isSleeping()) {
                  var4 = 1;
               } else if (this.ac.bC().isDead()) {
                  var4 = 2;
               } else if (ai.idealistic.vacan.utils.minecraft.world.c.h(this.ac.bC().getOpenInventory().getCursor())) {
                  var4 = 3;
               } else {
                  var4 = 0;
               }

               if (var4 != 0) {
                  String var5 = var3.toString().toLowerCase().replace("_", "-");
                  Block var6 = var2x.getClickedBlock();
                  if (var6 == null) {
                     this.et.c("actions, action: " + var5 + ", case: " + var4);
                  } else if (!d.e(var6)) {
                     this.et.c("actions, action: " + var5 + ", case: " + var4 + ", block: " + ai.idealistic.vacan.utils.minecraft.world.c.i(var6));
                  }
               }
            }

         });
      }

   }

   private Vector a(BlockFace var1) {
      Vector var2 = new Vector(var1.getModX(), var1.getModY(), var1.getModZ());
      if (var1.getModX() != 0 || var1.getModY() != 0 || var1.getModZ() != 0) {
         var2.normalize();
      }

      return var2;
   }
}
