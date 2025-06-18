package ai.idealistic.vacan.abstraction.f;

import ai.idealistic.vacan.abstraction.b.e;
import ai.idealistic.vacan.abstraction.b.f;
import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.abstraction.d.g;
import ai.idealistic.vacan.compatibility.Compatibility;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Generated;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class c {
   public long gg;
   private Player gh;
   private ai.idealistic.vacan.abstraction.b.d gi;
   public final d gj;
   public int gk;
   public int gl;
   public int gm;
   public int gn;
   public int go;
   public final boolean gp;
   public boolean fB;
   public boolean gq;
   public boolean gr;
   public boolean gs;
   public boolean fl;
   public boolean gt;
   public boolean gu;
   public boolean gv;
   public boolean gw;
   public boolean gx;
   private Location gy;
   private Location W;
   private Location cX;
   private Location gz;
   public String gA;
   private final Map<Long, Location> gB;
   public ai.idealistic.vacan.abstraction.d.c gC;
   public final List<ai.idealistic.vacan.abstraction.d.c> gD;
   public final List<ai.idealistic.vacan.abstraction.d.c> gE;
   public long gF;
   public final MultiVersion.MCVersion gG;
   public final f gH;
   public final Check.DetectionType M;
   private Check.DataType gI;
   private Set<ai.idealistic.vacan.utils.minecraft.entity.a> gJ;
   private ai.idealistic.vacan.abstraction.b.b gK;
   public final e gL;
   public g gM;
   public short gN;
   public long gO;
   public long gP;
   public long gQ;
   public long gR;
   public long gS;
   public long gT;
   public long gU;
   public long gV;
   private long gW;
   private long gX;
   private long gY;
   public boolean gZ;
   private ai.idealistic.vacan.abstraction.b.a.b ha;
   private ai.idealistic.vacan.abstraction.b.a.a hb;
   private Vector hc;
   private final Map<PotionEffectType, b> hd;
   private boolean he;
   private Entity[] hf;
   private final double[] hg;
   private final ai.idealistic.vacan.abstraction.check.e[] hh;

   public c(Player var1) {
      long var2 = System.currentTimeMillis();
      this.gh = var1;
      this.gg = var2;
      this.gG = MultiVersion.f(var1);
      this.gL = new e(var1);
      this.gp = var1.getAddress() == null;
      this.gj = new d(this);
      this.gI = ai.idealistic.vacan.compatibility.b.a.c(var1) ? Check.DataType.BEDROCK : Check.DataType.JAVA;
      this.M = this.bW() ? Check.DetectionType.PACKETS : Check.DetectionType.BUKKIT;
      this.fB = false;
      this.gq = false;
      this.gr = false;
      this.gs = false;
      this.W = ai.idealistic.vacan.utils.minecraft.b.a.k(var1);
      this.cX = null;
      this.gA = "";
      this.gy = null;
      this.gm = 0;
      this.gH = new f();
      this.gn = 0;
      this.gS = System.currentTimeMillis();
      this.gu = false;
      this.gF = var2;
      this.gi = new ai.idealistic.vacan.abstraction.b.d();
      this.gl = 0;
      this.gB = Collections.synchronizedMap(new LinkedHashMap());
      this.gC = null;
      this.gD = new ai.idealistic.vacan.utils.a.a();
      this.gE = new ai.idealistic.vacan.utils.a.a();
      this.gZ = false;
      this.gJ = new HashSet();
      this.gK = null;
      this.fl = false;
      this.gM = null;
      this.gN = -1939;
      this.gO = System.currentTimeMillis();
      this.gP = System.currentTimeMillis();
      this.gQ = 0L;
      this.gt = false;
      this.gv = false;
      this.gR = 0L;
      this.go = 0;
      this.ha = new ai.idealistic.vacan.abstraction.b.a.b();
      this.hb = new ai.idealistic.vacan.abstraction.b.a.a();
      this.gw = false;
      this.gx = false;
      this.gk = 0;
      this.gz = this.W;
      this.hc = new Vector();
      this.hd = new ConcurrentHashMap(2);
      this.cj();
      this.gW = System.currentTimeMillis();
      this.he = false;
      this.hf = new Entity[0];
      this.hg = new double[3];
      this.hh = new ai.idealistic.vacan.abstraction.check.e[CheckEnums.HackType.values().length];
      CheckEnums.HackType[] var4 = CheckEnums.HackType.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         CheckEnums.HackType var7 = var4[var6];

         try {
            this.hh[var7.ordinal()] = (ai.idealistic.vacan.abstraction.check.e)var7.executor.getConstructor(var7.getClass(), c.class).newInstance(var7, this);
         } catch (Exception var9) {
            var9.printStackTrace();
         }
      }

      this.bU().h(this);
   }

   public final Player bC() {
      return this.gh;
   }

   public void a(Player var1) {
      this.gh = var1;
   }

   public ai.idealistic.vacan.abstraction.check.e a(CheckEnums.HackType var1) {
      return this.hh[var1.ordinal()];
   }

   public void b(Object var1, Object var2) {
      ai.idealistic.vacan.abstraction.check.e[] var3 = this.ds();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         ai.idealistic.vacan.abstraction.check.e var6 = var3[var5];
         var6.a(var1, var2);
      }

   }

   private void bD() {
      this.gg = System.currentTimeMillis();
   }

   public long d(long var1) {
      return System.currentTimeMillis() - var1;
   }

   public long bE() {
      return System.currentTimeMillis() - this.gg;
   }

   public boolean a(MultiVersion.MCVersion var1) {
      return this.gG.ordinal() == var1.ordinal();
   }

   public boolean bF() {
      return this.gv && System.currentTimeMillis() - this.gO > 55L;
   }

   public boolean bG() {
      return this.gv && System.currentTimeMillis() - this.gO > 150L;
   }

   public boolean bH() {
      return this.gv && System.currentTimeMillis() - this.gO > 400L;
   }

   public boolean b(MultiVersion.MCVersion var1) {
      return this.gG.ordinal() >= var1.ordinal();
   }

   public boolean bI() {
      if (this.bW()) {
         return this.fB;
      } else {
         Entity var1 = this.cg();
         return var1 != null ? var1.isOnGround() : this.bC().isOnGround();
      }
   }

   public boolean bJ() {
      return this.bW() ? this.gq : this.bI();
   }

   public boolean bK() {
      return this.bW() ? this.gr : this.bC().isSprinting();
   }

   public boolean bL() {
      return this.bW() ? this.gs : this.bC().isSneaking();
   }

   public Location getLocation() {
      Location var1 = this.bW() ? this.W : ai.idealistic.vacan.compatibility.b.a.b.e(this.bC());
      return var1 != null ? var1 : ai.idealistic.vacan.abstraction.g.b.hm.clone();
   }

   public Location bM() {
      return this.cX != null ? this.cX : this.getLocation();
   }

   public Location bN() {
      Entity var1 = this.cg();
      return !(var1 instanceof LivingEntity) && !(var1 instanceof Vehicle) ? null : ai.idealistic.vacan.compatibility.b.a.b.f(var1);
   }

   public Location bO() {
      Location var1 = this.bN();
      return var1 == null ? this.getLocation() : var1;
   }

   public List<Entry<Long, Location>> bP() {
      synchronized(this.gB) {
         return new ArrayList(this.gB.entrySet());
      }
   }

   public List<Location> bQ() {
      synchronized(this.gB) {
         return new ArrayList(this.gB.values());
      }
   }

   public ai.idealistic.vacan.abstraction.g.b bR() {
      Location var1 = this.getLocation().clone();
      var1.setYaw(this.cX.getYaw());
      var1.setPitch(this.cX.getPitch());
      return new ai.idealistic.vacan.abstraction.g.b(var1);
   }

   public boolean l(Location var1) {
      if (var1.getX() == ai.idealistic.vacan.abstraction.g.b.hm.getX() && var1.getY() == ai.idealistic.vacan.abstraction.g.b.hm.getY() && var1.getZ() == ai.idealistic.vacan.abstraction.g.b.hm.getZ()) {
         return false;
      } else {
         boolean var2 = ai.idealistic.vacan.functionality.server.c.fe();
         if (MultiVersion.jg) {
            if (var2) {
               this.bC().leaveVehicle();
            }

            this.bC().teleportAsync(var1);
         } else if (var2) {
            this.bC().leaveVehicle();
            this.bC().teleport(var1);
         } else {
            ai.idealistic.vacan.functionality.server.c.b(this, () -> {
               Player var2 = this.bC();
               if (var2.isOnline()) {
                  var2.teleport(var1);
               }

            });
         }

         return true;
      }
   }

   public int bS() {
      if (MultiVersion.c(MultiVersion.MCVersion.V1_17)) {
         return this.bC().isOnline() ? this.bC().getPing() : 0;
      } else {
         try {
            Object var1 = ai.idealistic.vacan.functionality.server.c.b(this.bC(), "ping");
            return var1 instanceof Integer ? Math.max((Integer)var1, 0) : 0;
         } catch (Exception var2) {
            return 0;
         }
      }
   }

   public UUID bT() {
      return ai.idealistic.vacan.compatibility.b.a.b.a(this.bC()) ? UUID.randomUUID() : this.bC().getUniqueId();
   }

   public ai.idealistic.vacan.abstraction.profiling.a bU() {
      return ai.idealistic.vacan.functionality.d.d.y(this);
   }

   public void u(boolean var1) {
      this.gq = this.fB;
      this.fB = var1;
   }

   public void m(Location var1) {
      synchronized(this.gB) {
         if (this.gB.size() == 20) {
            Iterator var3 = this.gB.keySet().iterator();
            var3.next();
            var3.remove();
         }

         this.gB.put(System.currentTimeMillis(), var1.clone());
      }
   }

   public World bV() {
      return this.getLocation().getWorld();
   }

   public boolean bW() {
      return ai.idealistic.vacan.functionality.server.c.bW() && !this.bX();
   }

   public boolean bX() {
      return this.gI == Check.DataType.BEDROCK;
   }

   public boolean bY() {
      return this.cn() < 1.0D;
   }

   public boolean s(double var1) {
      return ai.idealistic.vacan.utils.minecraft.entity.d.a(var1, ai.idealistic.vacan.utils.minecraft.entity.d.a(this, ai.idealistic.vacan.utils.minecraft.entity.e.lD) + 1, ai.idealistic.vacan.utils.minecraft.world.e.nE);
   }

   public boolean t(double var1) {
      return ai.idealistic.vacan.utils.minecraft.entity.d.b(var1, ai.idealistic.vacan.utils.minecraft.entity.d.a(this, ai.idealistic.vacan.utils.minecraft.entity.e.lD) + 1, ai.idealistic.vacan.utils.minecraft.world.e.nE);
   }

   public boolean a(Location var1, Location var2, ai.idealistic.vacan.abstraction.g.b var3, Location var4, boolean var5) {
      if (MultiVersion.c(MultiVersion.MCVersion.V1_17) || this.b(MultiVersion.MCVersion.V1_17)) {
         double var6 = this.a(var3.dT(), -3.0E7D, 3.0E7D);
         double var8 = this.a(var3.dU(), -2.0E7D, 2.0E7D);
         double var10 = this.a(var3.dV(), -3.0E7D, 3.0E7D);
         Vector var12 = new Vector(var6, var8, var10);
         double var13 = this.hc.distanceSquared(var12);
         this.hc = var12;
         if (var13 < 4.0E-8D) {
            return false;
         }
      }

      if (!var5) {
         this.p(var4);
      }

      return true;
   }

   private double a(double var1, double var3, double var5) {
      return var1 < var3 ? var3 : Math.min(var1, var5);
   }

   public void bZ() {
      this.gW = System.currentTimeMillis();
   }

   private void ca() {
      long var1 = System.currentTimeMillis() - this.gW;
      if (var1 >= 20000L) {
         if (!this.he) {
            this.bU().bw().a(System.currentTimeMillis(), this.bE() - var1, true);
            this.he = true;
         }
      } else if (this.he) {
         this.bD();
         this.he = false;
      }

   }

   public boolean cb() {
      return this.he || this.gp;
   }

   public String toString() {
      return this.bC().getName();
   }

   public boolean a(boolean var1, boolean var2, boolean var3, Object... var4) {
      if (var1 && this.bC().isWhitelisted()) {
         String var5 = "§f" + this.bC().getName() + " ";
         if (var4 != null && var4.length != 0) {
            int var6 = 0;
            Object[] var7;
            int var8;
            int var9;
            Object var10;
            if (var3) {
               var7 = var4;
               var8 = var4.length;

               for(var9 = 0; var9 < var8; ++var9) {
                  var10 = var7[var9];
                  if (var10 instanceof Double) {
                     var4[var6] = ((var6 + 1) % 2 == 0 ? "§c" : "§7") + ai.idealistic.vacan.utils.b.a.e((Double)var10, (double)ai.idealistic.vacan.utils.minecraft.world.e.nF);
                  } else {
                     var4[var6] = ((var6 + 1) % 2 == 0 ? "§c" : "§7") + var10;
                  }

                  ++var6;
               }
            } else {
               var7 = var4;
               var8 = var4.length;

               for(var9 = 0; var9 < var8; ++var9) {
                  var10 = var7[var9];
                  var4[var6] = ((var6 + 1) % 2 == 0 ? "§c" : "§7") + var10;
                  ++var6;
               }
            }

            var5 = var5 + ai.idealistic.vacan.utils.a.g.a(var4, " ");
         } else {
            var5 = var5 + (new Random()).nextInt();
         }

         Collection var11 = ai.idealistic.vacan.functionality.server.c.fc();
         if (!var11.isEmpty()) {
            if (var2) {
               Bukkit.broadcastMessage(var5);
            } else {
               Iterator var12 = var11.iterator();

               while(var12.hasNext()) {
                  c var13 = (c)var12.next();
                  if (var13.bC().isOp()) {
                     var13.bC().sendMessage(var5);
                  }
               }
            }
         }

         Bukkit.getConsoleSender().sendMessage(var5);
         return true;
      } else {
         return false;
      }
   }

   public int cc() {
      return this.bX() ? 512 : (!MultiVersion.c(MultiVersion.MCVersion.V1_11) && !this.b(MultiVersion.MCVersion.V1_11) && !ai.idealistic.vacan.utils.minecraft.c.b.h("viaversion") && !Compatibility.CompatibilityType.PROTOCOL_SUPPORT.isFunctional() ? 100 : 256);
   }

   public void C(String var1) {
      this.bC().sendMessage("");
      this.bC().sendMessage(var1);
      this.bC().sendMessage("");
   }

   public Inventory b(int var1, String var2) {
      return Bukkit.createInventory(this.bC(), var1, var2);
   }

   public PlayerInventory cd() {
      return new a(ai.idealistic.vacan.compatibility.b.a.b.a(this.bC()) ? null : this.bC().getInventory());
   }

   public ItemStack getItemInHand() {
      return this.cd().getItemInHand();
   }

   public ai.idealistic.vacan.abstraction.g.b d(double var1, double var3) {
      for(int var5 = 0; var5 < ai.idealistic.vacan.utils.b.a.B(Math.min(var1, var3)); ++var5) {
         ai.idealistic.vacan.abstraction.g.b var6 = new ai.idealistic.vacan.abstraction.g.b(this.getLocation().clone().add(0.0D, this.cn(), 0.0D).add(this.getLocation().getDirection().multiply(var5)));
         if (ai.idealistic.vacan.utils.minecraft.world.c.ac(var6.dO().dz())) {
            return var6.dQ();
         }
      }

      return null;
   }

   public boolean ce() {
      return MultiVersion.c(MultiVersion.MCVersion.V1_17) ? this.bC().isFrozen() : false;
   }

   public float cf() {
      return MultiVersion.c(MultiVersion.MCVersion.V1_17) ? this.bC().getAttackCooldown() : 1.0F;
   }

   public Entity cg() {
      return ai.idealistic.vacan.compatibility.b.a.b.g(this.bC());
   }

   public double ch() {
      return ai.idealistic.vacan.compatibility.b.a.b.a(this.bC()) ? 0.0D : this.bC().getHealth();
   }

   public int ci() {
      return ai.idealistic.vacan.compatibility.b.a.b.a(this.bC()) ? (new Random()).nextInt() : this.bC().getEntityId();
   }

   private void cj() {
      if (!ai.idealistic.vacan.compatibility.b.a.b.a(this.bC())) {
         ai.idealistic.vacan.functionality.server.c.b(this, () -> {
            Iterator var1 = this.bC().getActivePotionEffects().iterator();

            while(var1.hasNext()) {
               PotionEffect var2 = (PotionEffect)var1.next();
               this.hd.put(var2.getType(), new b(var2));
            }

         });
      }

   }

   public Collection<PotionEffect> ck() {
      return (Collection)(ai.idealistic.vacan.compatibility.b.a.b.a(this.bC()) ? new ArrayList(0) : this.bC().getActivePotionEffects());
   }

   public b a(PotionEffectType var1, long var2) {
      this.cj();
      b var4 = (b)this.hd.get(var1);
      return var4 != null && var4.bA() <= var2 && var4.gf.getType().equals(var1) ? var4 : null;
   }

   public boolean b(PotionEffectType var1, long var2) {
      this.cj();
      b var4 = (b)this.hd.get(var1);
      return var4 != null && var4.bA() <= var2 && var4.gf.getType().equals(var1);
   }

   public GameMode cl() {
      return ai.idealistic.vacan.compatibility.b.a.b.a(this.bC()) ? GameMode.SURVIVAL : this.gh.getGameMode();
   }

   public List<Entity> u(double var1) {
      this.hg[0] = Math.max(var1, this.hg[0]);
      this.hg[1] = Math.max(var1, this.hg[1]);
      this.hg[2] = Math.max(var1, this.hg[2]);
      if (ai.idealistic.vacan.functionality.server.c.fe()) {
         List var18 = this.bC().getNearbyEntities(var1, var1, var1);
         this.hf = (Entity[])var18.toArray(new Entity[0]);
         return var18;
      } else if (this.hf.length == 0) {
         return new ArrayList(0);
      } else {
         ArrayList var3 = new ArrayList();
         Location var4 = this.getLocation();
         int var5 = ai.idealistic.vacan.utils.b.c.I((var4.getX() - var1) / 16.0D);
         int var6 = ai.idealistic.vacan.utils.b.c.I((var4.getX() + var1) / 16.0D);
         int var7 = ai.idealistic.vacan.utils.b.c.I((var4.getZ() - var1) / 16.0D);
         int var8 = ai.idealistic.vacan.utils.b.c.I((var4.getZ() + var1) / 16.0D);
         double var9 = var1 * var1;

         for(int var11 = var5; var11 <= var6; ++var11) {
            for(int var12 = var7; var12 <= var8; ++var12) {
               Entity[] var13 = this.hf;
               int var14 = var13.length;

               for(int var15 = 0; var15 < var14; ++var15) {
                  Entity var16 = var13[var15];
                  Location var17 = ai.idealistic.vacan.compatibility.b.a.b.f(var16);
                  if (var17 != null && ai.idealistic.vacan.abstraction.g.b.c(var17, var4) <= var9) {
                     var3.add(var16);
                  }
               }
            }
         }

         var3.remove(this.bC());
         return var3;
      }
   }

   public List<Entity> b(double var1, double var3, double var5) {
      this.hg[0] = Math.max(var1, this.hg[0]);
      this.hg[1] = Math.max(var3, this.hg[1]);
      this.hg[2] = Math.max(var5, this.hg[2]);
      if (ai.idealistic.vacan.functionality.server.c.fe()) {
         List var20 = this.bC().getNearbyEntities(var1, var3, var5);
         this.hf = (Entity[])var20.toArray(new Entity[0]);
         return var20;
      } else if (this.hf.length == 0) {
         return new ArrayList(0);
      } else {
         ArrayList var7 = new ArrayList();
         Location var8 = this.getLocation();
         int var9 = ai.idealistic.vacan.utils.b.c.I((var8.getX() - var1) / 16.0D);
         int var10 = ai.idealistic.vacan.utils.b.c.I((var8.getX() + var1) / 16.0D);
         int var11 = ai.idealistic.vacan.utils.b.c.I((var8.getZ() - var5) / 16.0D);
         int var12 = ai.idealistic.vacan.utils.b.c.I((var8.getZ() + var5) / 16.0D);

         for(int var13 = var9; var13 <= var10; ++var13) {
            for(int var14 = var11; var14 <= var12; ++var14) {
               Entity[] var15 = this.hf;
               int var16 = var15.length;

               for(int var17 = 0; var17 < var16; ++var17) {
                  Entity var18 = var15[var17];
                  Location var19 = ai.idealistic.vacan.compatibility.b.a.b.f(var18);
                  if (var19 != null && Math.abs(var19.getX() - var8.getX()) <= var1 && Math.abs(var19.getY() - var8.getY()) <= var3 && Math.abs(var19.getZ() - var8.getZ()) <= var5) {
                     var7.add(var18);
                  }
               }
            }
         }

         var7.remove(this.bC());
         return var7;
      }
   }

   public boolean cm() {
      Location var1 = this.getLocation();
      ai.idealistic.vacan.abstraction.g.b var2 = new ai.idealistic.vacan.abstraction.g.b(var1.clone().add(0.0D, 1.0D, 0.0D));
      if (ai.idealistic.vacan.utils.minecraft.world.c.ab(var2.dO().dz()) && !ai.idealistic.vacan.utils.minecraft.world.c.k(var2.dO().dz()) && !ai.idealistic.vacan.utils.minecraft.world.c.a(var2.dO().dz(), false)) {
         return false;
      } else {
         World var3 = this.bV();
         double var4 = Math.min((double)ai.idealistic.vacan.utils.minecraft.world.c.b(var3), var1.getY());
         int var6 = 0;

         for(double var7 = var4; var4 > (double)ai.idealistic.vacan.utils.minecraft.world.c.c(var3); --var7) {
            ai.idealistic.vacan.abstraction.g.b var9 = new ai.idealistic.vacan.abstraction.g.b(var1.clone().add(0.0D, -(var4 - var7), 0.0D));
            Material var10 = var9.dO().dz();
            if ((double)var6 == 16.0D || !ai.idealistic.vacan.utils.minecraft.world.c.a(var10, false) && !ai.idealistic.vacan.utils.minecraft.world.c.k(var10) && ai.idealistic.vacan.utils.minecraft.world.c.ab(var10)) {
               var9.x(Math.floor(var7) + 1.0D);
               if (this.bW()) {
                  this.l(var9.dR());
               }
               break;
            }

            ++var6;
         }

         if (var6 > 0) {
            this.bC().setFallDistance(0.0F);
            if (ai.idealistic.vacan.functionality.server.a.iZ.i("Detections.fall_damage_on_teleport") && var6 > 3) {
               this.bC().damage((double)Math.max(this.bC().getFallDistance(), (float)var6));
            }
         }

         return true;
      }
   }

   public boolean v(double var1) {
      Location var3 = this.getLocation();
      WorldBorder var4 = this.bV().getWorldBorder();
      double var5 = var4.getSize() / 2.0D + var1;
      Location var7 = var4.getCenter();
      return Math.abs(var3.getX() - var7.getX()) > var5 || Math.abs(var3.getZ() - var7.getZ()) > var5;
   }

   public double cn() {
      return ai.idealistic.vacan.compatibility.b.a.b.h(this.bC());
   }

   public boolean co() {
      if (MultiVersion.c(MultiVersion.MCVersion.V1_9)) {
         if (this.bC().isGliding()) {
            this.gY = System.currentTimeMillis();
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public boolean cp() {
      return MultiVersion.c(MultiVersion.MCVersion.V1_13) ? this.bC().isSwimming() : false;
   }

   public boolean cq() {
      return this.co() || (double)(System.currentTimeMillis() - this.gY) <= 1000.0D;
   }

   public boolean cr() {
      Entity var1 = this.cg();
      boolean var2;
      if (var1 != null) {
         var2 = var1 instanceof Player && ((Player)var1).isFlying();
      } else {
         var2 = this.bC().isFlying();
      }

      if (var2) {
         this.gX = System.currentTimeMillis();
      }

      return var2;
   }

   public boolean cs() {
      return this.cr() || (double)(System.currentTimeMillis() - this.gX) <= 1000.0D;
   }

   @Generated
   public long ct() {
      return this.gg;
   }

   @Generated
   public Player cu() {
      return this.gh;
   }

   @Generated
   public d cv() {
      return this.gj;
   }

   @Generated
   public int cw() {
      return this.gk;
   }

   @Generated
   public int cx() {
      return this.gl;
   }

   @Generated
   public int cy() {
      return this.gm;
   }

   @Generated
   public int cz() {
      return this.gn;
   }

   @Generated
   public int cA() {
      return this.go;
   }

   @Generated
   public boolean cB() {
      return this.gp;
   }

   @Generated
   public boolean cC() {
      return this.fl;
   }

   @Generated
   public boolean cD() {
      return this.gt;
   }

   @Generated
   public boolean cE() {
      return this.gu;
   }

   @Generated
   public boolean cF() {
      return this.gv;
   }

   @Generated
   public boolean cG() {
      return this.gw;
   }

   @Generated
   public boolean cH() {
      return this.gx;
   }

   @Generated
   public Location cI() {
      return this.cX;
   }

   @Generated
   public Location cJ() {
      return this.gz;
   }

   @Generated
   public String cK() {
      return this.gA;
   }

   @Generated
   public ai.idealistic.vacan.abstraction.d.c cL() {
      return this.gC;
   }

   @Generated
   public List<ai.idealistic.vacan.abstraction.d.c> cM() {
      return this.gD;
   }

   @Generated
   public List<ai.idealistic.vacan.abstraction.d.c> cN() {
      return this.gE;
   }

   @Generated
   public long cO() {
      return this.gF;
   }

   @Generated
   public MultiVersion.MCVersion cP() {
      return this.gG;
   }

   @Generated
   public f cQ() {
      return this.gH;
   }

   @Generated
   public Check.DetectionType cR() {
      return this.M;
   }

   @Generated
   public Set<ai.idealistic.vacan.utils.minecraft.entity.a> cS() {
      return this.gJ;
   }

   @Generated
   public ai.idealistic.vacan.abstraction.b.b cT() {
      return this.gK;
   }

   @Generated
   public e cU() {
      return this.gL;
   }

   @Generated
   public g cV() {
      return this.gM;
   }

   @Generated
   public short cW() {
      return this.gN;
   }

   @Generated
   public long cX() {
      return this.gO;
   }

   @Generated
   public long cY() {
      return this.gP;
   }

   @Generated
   public long cZ() {
      return this.gQ;
   }

   @Generated
   public long da() {
      return this.gR;
   }

   @Generated
   public long db() {
      return this.gS;
   }

   @Generated
   public long dc() {
      return this.gT;
   }

   @Generated
   public long dd() {
      return this.gU;
   }

   @Generated
   public long de() {
      return this.gV;
   }

   @Generated
   public long df() {
      return this.gW;
   }

   @Generated
   public long dg() {
      return this.gX;
   }

   @Generated
   public long dh() {
      return this.gY;
   }

   @Generated
   public boolean di() {
      return this.gZ;
   }

   @Generated
   public ai.idealistic.vacan.abstraction.b.a.b dj() {
      return this.ha;
   }

   @Generated
   public ai.idealistic.vacan.abstraction.b.a.a dk() {
      return this.hb;
   }

   @Generated
   public Vector dl() {
      return this.hc;
   }

   @Generated
   public Map<PotionEffectType, b> dm() {
      return this.hd;
   }

   @Generated
   public Entity[] dn() {
      return this.hf;
   }

   @Generated
   public double[] do() {
      return this.hg;
   }

   @Generated
   public void e(long var1) {
      this.gg = var1;
   }

   @Generated
   public void b(Player var1) {
      this.gh = var1;
   }

   @Generated
   public void a(ai.idealistic.vacan.abstraction.b.d var1) {
      this.gi = var1;
   }

   @Generated
   public void e(int var1) {
      this.gk = var1;
   }

   @Generated
   public void f(int var1) {
      this.gl = var1;
   }

   @Generated
   public void g(int var1) {
      this.gm = var1;
   }

   @Generated
   public void h(int var1) {
      this.gn = var1;
   }

   @Generated
   public void i(int var1) {
      this.go = var1;
   }

   @Generated
   public void v(boolean var1) {
      this.gq = var1;
   }

   @Generated
   public void w(boolean var1) {
      this.gr = var1;
   }

   @Generated
   public void x(boolean var1) {
      this.gs = var1;
   }

   @Generated
   public void y(boolean var1) {
      this.fl = var1;
   }

   @Generated
   public void z(boolean var1) {
      this.gt = var1;
   }

   @Generated
   public void A(boolean var1) {
      this.gu = var1;
   }

   @Generated
   public void B(boolean var1) {
      this.gv = var1;
   }

   @Generated
   public void C(boolean var1) {
      this.gw = var1;
   }

   @Generated
   public void D(boolean var1) {
      this.gx = var1;
   }

   @Generated
   public void D(String var1) {
      this.gA = var1;
   }

   @Generated
   public void a(ai.idealistic.vacan.abstraction.d.c var1) {
      this.gC = var1;
   }

   @Generated
   public void f(long var1) {
      this.gF = var1;
   }

   @Generated
   public void i(Check.DataType var1) {
      this.gI = var1;
   }

   @Generated
   public void a(Set<ai.idealistic.vacan.utils.minecraft.entity.a> var1) {
      this.gJ = var1;
   }

   @Generated
   public void c(g var1) {
      this.gM = var1;
   }

   @Generated
   public void a(short var1) {
      this.gN = var1;
   }

   @Generated
   public void g(long var1) {
      this.gO = var1;
   }

   @Generated
   public void h(long var1) {
      this.gP = var1;
   }

   @Generated
   public void i(long var1) {
      this.gQ = var1;
   }

   @Generated
   public void j(long var1) {
      this.gR = var1;
   }

   @Generated
   public void k(long var1) {
      this.gS = var1;
   }

   @Generated
   public void l(long var1) {
      this.gT = var1;
   }

   @Generated
   public void m(long var1) {
      this.gU = var1;
   }

   @Generated
   public void n(long var1) {
      this.gV = var1;
   }

   @Generated
   public void o(long var1) {
      this.gW = var1;
   }

   @Generated
   public void p(long var1) {
      this.gX = var1;
   }

   @Generated
   public void q(long var1) {
      this.gY = var1;
   }

   @Generated
   public void E(boolean var1) {
      this.gZ = var1;
   }

   @Generated
   public void a(ai.idealistic.vacan.abstraction.b.a.b var1) {
      this.ha = var1;
   }

   @Generated
   public void a(ai.idealistic.vacan.abstraction.b.a.a var1) {
      this.hb = var1;
   }

   @Generated
   public void b(Vector var1) {
      this.hc = var1;
   }

   @Generated
   public void F(boolean var1) {
      this.he = var1;
   }

   @Generated
   public void a(Entity[] var1) {
      this.hf = var1;
   }

   @Generated
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof c)) {
         return false;
      } else {
         c var2 = (c)var1;
         if (!var2.e(this)) {
            return false;
         } else if (this.ct() != var2.ct()) {
            return false;
         } else if (this.cw() != var2.cw()) {
            return false;
         } else if (this.cx() != var2.cx()) {
            return false;
         } else if (this.cy() != var2.cy()) {
            return false;
         } else if (this.cz() != var2.cz()) {
            return false;
         } else if (this.cA() != var2.cA()) {
            return false;
         } else if (this.cB() != var2.cB()) {
            return false;
         } else if (this.bI() != var2.bI()) {
            return false;
         } else if (this.bJ() != var2.bJ()) {
            return false;
         } else if (this.bK() != var2.bK()) {
            return false;
         } else if (this.bL() != var2.bL()) {
            return false;
         } else if (this.cC() != var2.cC()) {
            return false;
         } else if (this.cD() != var2.cD()) {
            return false;
         } else if (this.cE() != var2.cE()) {
            return false;
         } else if (this.cF() != var2.cF()) {
            return false;
         } else if (this.cG() != var2.cG()) {
            return false;
         } else if (this.cH() != var2.cH()) {
            return false;
         } else if (this.cO() != var2.cO()) {
            return false;
         } else if (this.cW() != var2.cW()) {
            return false;
         } else if (this.cX() != var2.cX()) {
            return false;
         } else if (this.cY() != var2.cY()) {
            return false;
         } else if (this.cZ() != var2.cZ()) {
            return false;
         } else if (this.da() != var2.da()) {
            return false;
         } else if (this.db() != var2.db()) {
            return false;
         } else if (this.dc() != var2.dc()) {
            return false;
         } else if (this.dd() != var2.dd()) {
            return false;
         } else if (this.de() != var2.de()) {
            return false;
         } else if (this.df() != var2.df()) {
            return false;
         } else if (this.dg() != var2.dg()) {
            return false;
         } else if (this.dh() != var2.dh()) {
            return false;
         } else if (this.di() != var2.di()) {
            return false;
         } else if (this.cb() != var2.cb()) {
            return false;
         } else {
            label391: {
               Player var3 = this.cu();
               Player var4 = var2.cu();
               if (var3 == null) {
                  if (var4 == null) {
                     break label391;
                  }
               } else if (var3.equals(var4)) {
                  break label391;
               }

               return false;
            }

            ai.idealistic.vacan.abstraction.b.d var5 = this.dp();
            ai.idealistic.vacan.abstraction.b.d var6 = var2.dp();
            if (var5 == null) {
               if (var6 != null) {
                  return false;
               }
            } else if (!var5.equals(var6)) {
               return false;
            }

            label377: {
               d var7 = this.cv();
               d var8 = var2.cv();
               if (var7 == null) {
                  if (var8 == null) {
                     break label377;
                  }
               } else if (var7.equals(var8)) {
                  break label377;
               }

               return false;
            }

            Location var9 = this.dq();
            Location var10 = var2.dq();
            if (var9 == null) {
               if (var10 != null) {
                  return false;
               }
            } else if (!var9.equals(var10)) {
               return false;
            }

            label363: {
               Location var11 = this.getLocation();
               Location var12 = var2.getLocation();
               if (var11 == null) {
                  if (var12 == null) {
                     break label363;
                  }
               } else if (var11.equals(var12)) {
                  break label363;
               }

               return false;
            }

            Location var13 = this.cI();
            Location var14 = var2.cI();
            if (var13 == null) {
               if (var14 != null) {
                  return false;
               }
            } else if (!var13.equals(var14)) {
               return false;
            }

            label349: {
               Location var15 = this.cJ();
               Location var16 = var2.cJ();
               if (var15 == null) {
                  if (var16 == null) {
                     break label349;
                  }
               } else if (var15.equals(var16)) {
                  break label349;
               }

               return false;
            }

            label342: {
               String var17 = this.cK();
               String var18 = var2.cK();
               if (var17 == null) {
                  if (var18 == null) {
                     break label342;
                  }
               } else if (var17.equals(var18)) {
                  break label342;
               }

               return false;
            }

            List var19 = this.bQ();
            List var20 = var2.bQ();
            if (var19 == null) {
               if (var20 != null) {
                  return false;
               }
            } else if (!var19.equals(var20)) {
               return false;
            }

            label328: {
               ai.idealistic.vacan.abstraction.d.c var21 = this.cL();
               ai.idealistic.vacan.abstraction.d.c var22 = var2.cL();
               if (var21 == null) {
                  if (var22 == null) {
                     break label328;
                  }
               } else if (var21.equals(var22)) {
                  break label328;
               }

               return false;
            }

            label321: {
               List var23 = this.cM();
               List var24 = var2.cM();
               if (var23 == null) {
                  if (var24 == null) {
                     break label321;
                  }
               } else if (var23.equals(var24)) {
                  break label321;
               }

               return false;
            }

            List var25 = this.cN();
            List var26 = var2.cN();
            if (var25 == null) {
               if (var26 != null) {
                  return false;
               }
            } else if (!var25.equals(var26)) {
               return false;
            }

            MultiVersion.MCVersion var27 = this.cP();
            MultiVersion.MCVersion var28 = var2.cP();
            if (var27 == null) {
               if (var28 != null) {
                  return false;
               }
            } else if (!var27.equals(var28)) {
               return false;
            }

            label300: {
               f var29 = this.cQ();
               f var30 = var2.cQ();
               if (var29 == null) {
                  if (var30 == null) {
                     break label300;
                  }
               } else if (var29.equals(var30)) {
                  break label300;
               }

               return false;
            }

            Check.DetectionType var31 = this.cR();
            Check.DetectionType var32 = var2.cR();
            if (var31 == null) {
               if (var32 != null) {
                  return false;
               }
            } else if (!var31.equals(var32)) {
               return false;
            }

            Check.DataType var33 = this.dr();
            Check.DataType var34 = var2.dr();
            if (var33 == null) {
               if (var34 != null) {
                  return false;
               }
            } else if (!var33.equals(var34)) {
               return false;
            }

            label279: {
               Set var35 = this.cS();
               Set var36 = var2.cS();
               if (var35 == null) {
                  if (var36 == null) {
                     break label279;
                  }
               } else if (var35.equals(var36)) {
                  break label279;
               }

               return false;
            }

            ai.idealistic.vacan.abstraction.b.b var37 = this.cT();
            ai.idealistic.vacan.abstraction.b.b var38 = var2.cT();
            if (var37 == null) {
               if (var38 != null) {
                  return false;
               }
            } else if (!var37.equals(var38)) {
               return false;
            }

            label265: {
               e var39 = this.cU();
               e var40 = var2.cU();
               if (var39 == null) {
                  if (var40 == null) {
                     break label265;
                  }
               } else if (var39.equals(var40)) {
                  break label265;
               }

               return false;
            }

            g var41 = this.cV();
            g var42 = var2.cV();
            if (var41 == null) {
               if (var42 != null) {
                  return false;
               }
            } else if (!var41.equals(var42)) {
               return false;
            }

            label251: {
               ai.idealistic.vacan.abstraction.b.a.b var43 = this.dj();
               ai.idealistic.vacan.abstraction.b.a.b var44 = var2.dj();
               if (var43 == null) {
                  if (var44 == null) {
                     break label251;
                  }
               } else if (var43.equals(var44)) {
                  break label251;
               }

               return false;
            }

            ai.idealistic.vacan.abstraction.b.a.a var45 = this.dk();
            ai.idealistic.vacan.abstraction.b.a.a var46 = var2.dk();
            if (var45 == null) {
               if (var46 != null) {
                  return false;
               }
            } else if (!var45.equals(var46)) {
               return false;
            }

            label237: {
               Vector var47 = this.dl();
               Vector var48 = var2.dl();
               if (var47 == null) {
                  if (var48 == null) {
                     break label237;
                  }
               } else if (var47.equals(var48)) {
                  break label237;
               }

               return false;
            }

            Map var49 = this.dm();
            Map var50 = var2.dm();
            if (var49 == null) {
               if (var50 != null) {
                  return false;
               }
            } else if (!var49.equals(var50)) {
               return false;
            }

            if (!Arrays.deepEquals(this.dn(), var2.dn())) {
               return false;
            } else if (!Arrays.equals(this.do(), var2.do())) {
               return false;
            } else if (!Arrays.deepEquals(this.ds(), var2.ds())) {
               return false;
            } else {
               return true;
            }
         }
      }
   }

   @Generated
   protected boolean e(Object var1) {
      return var1 instanceof c;
   }

   @Generated
   public int hashCode() {
      boolean var1 = true;
      byte var2 = 1;
      long var3 = this.ct();
      int var53 = var2 * 59 + (int)(var3 >>> 32 ^ var3);
      var53 = var53 * 59 + this.cw();
      var53 = var53 * 59 + this.cx();
      var53 = var53 * 59 + this.cy();
      var53 = var53 * 59 + this.cz();
      var53 = var53 * 59 + this.cA();
      var53 = var53 * 59 + (this.cB() ? 79 : 97);
      var53 = var53 * 59 + (this.bI() ? 79 : 97);
      var53 = var53 * 59 + (this.bJ() ? 79 : 97);
      var53 = var53 * 59 + (this.bK() ? 79 : 97);
      var53 = var53 * 59 + (this.bL() ? 79 : 97);
      var53 = var53 * 59 + (this.cC() ? 79 : 97);
      var53 = var53 * 59 + (this.cD() ? 79 : 97);
      var53 = var53 * 59 + (this.cE() ? 79 : 97);
      var53 = var53 * 59 + (this.cF() ? 79 : 97);
      var53 = var53 * 59 + (this.cG() ? 79 : 97);
      var53 = var53 * 59 + (this.cH() ? 79 : 97);
      long var5 = this.cO();
      var53 = var53 * 59 + (int)(var5 >>> 32 ^ var5);
      var53 = var53 * 59 + this.cW();
      long var7 = this.cX();
      var53 = var53 * 59 + (int)(var7 >>> 32 ^ var7);
      long var9 = this.cY();
      var53 = var53 * 59 + (int)(var9 >>> 32 ^ var9);
      long var11 = this.cZ();
      var53 = var53 * 59 + (int)(var11 >>> 32 ^ var11);
      long var13 = this.da();
      var53 = var53 * 59 + (int)(var13 >>> 32 ^ var13);
      long var15 = this.db();
      var53 = var53 * 59 + (int)(var15 >>> 32 ^ var15);
      long var17 = this.dc();
      var53 = var53 * 59 + (int)(var17 >>> 32 ^ var17);
      long var19 = this.dd();
      var53 = var53 * 59 + (int)(var19 >>> 32 ^ var19);
      long var21 = this.de();
      var53 = var53 * 59 + (int)(var21 >>> 32 ^ var21);
      long var23 = this.df();
      var53 = var53 * 59 + (int)(var23 >>> 32 ^ var23);
      long var25 = this.dg();
      var53 = var53 * 59 + (int)(var25 >>> 32 ^ var25);
      long var27 = this.dh();
      var53 = var53 * 59 + (int)(var27 >>> 32 ^ var27);
      var53 = var53 * 59 + (this.di() ? 79 : 97);
      var53 = var53 * 59 + (this.cb() ? 79 : 97);
      Player var29 = this.cu();
      var53 = var53 * 59 + (var29 == null ? 43 : var29.hashCode());
      ai.idealistic.vacan.abstraction.b.d var30 = this.dp();
      var53 = var53 * 59 + (var30 == null ? 43 : var30.hashCode());
      d var31 = this.cv();
      var53 = var53 * 59 + (var31 == null ? 43 : var31.hashCode());
      Location var32 = this.dq();
      var53 = var53 * 59 + (var32 == null ? 43 : var32.hashCode());
      Location var33 = this.getLocation();
      var53 = var53 * 59 + (var33 == null ? 43 : var33.hashCode());
      Location var34 = this.cI();
      var53 = var53 * 59 + (var34 == null ? 43 : var34.hashCode());
      Location var35 = this.cJ();
      var53 = var53 * 59 + (var35 == null ? 43 : var35.hashCode());
      String var36 = this.cK();
      var53 = var53 * 59 + (var36 == null ? 43 : var36.hashCode());
      List var37 = this.bQ();
      var53 = var53 * 59 + (var37 == null ? 43 : var37.hashCode());
      ai.idealistic.vacan.abstraction.d.c var38 = this.cL();
      var53 = var53 * 59 + (var38 == null ? 43 : var38.hashCode());
      List var39 = this.cM();
      var53 = var53 * 59 + (var39 == null ? 43 : var39.hashCode());
      List var40 = this.cN();
      var53 = var53 * 59 + (var40 == null ? 43 : var40.hashCode());
      MultiVersion.MCVersion var41 = this.cP();
      var53 = var53 * 59 + (var41 == null ? 43 : var41.hashCode());
      f var42 = this.cQ();
      var53 = var53 * 59 + (var42 == null ? 43 : var42.hashCode());
      Check.DetectionType var43 = this.cR();
      var53 = var53 * 59 + (var43 == null ? 43 : var43.hashCode());
      Check.DataType var44 = this.dr();
      var53 = var53 * 59 + (var44 == null ? 43 : var44.hashCode());
      Set var45 = this.cS();
      var53 = var53 * 59 + (var45 == null ? 43 : var45.hashCode());
      ai.idealistic.vacan.abstraction.b.b var46 = this.cT();
      var53 = var53 * 59 + (var46 == null ? 43 : var46.hashCode());
      e var47 = this.cU();
      var53 = var53 * 59 + (var47 == null ? 43 : var47.hashCode());
      g var48 = this.cV();
      var53 = var53 * 59 + (var48 == null ? 43 : var48.hashCode());
      ai.idealistic.vacan.abstraction.b.a.b var49 = this.dj();
      var53 = var53 * 59 + (var49 == null ? 43 : var49.hashCode());
      ai.idealistic.vacan.abstraction.b.a.a var50 = this.dk();
      var53 = var53 * 59 + (var50 == null ? 43 : var50.hashCode());
      Vector var51 = this.dl();
      var53 = var53 * 59 + (var51 == null ? 43 : var51.hashCode());
      Map var52 = this.dm();
      var53 = var53 * 59 + (var52 == null ? 43 : var52.hashCode());
      var53 = var53 * 59 + Arrays.deepHashCode(this.dn());
      var53 = var53 * 59 + Arrays.hashCode(this.do());
      var53 = var53 * 59 + Arrays.deepHashCode(this.ds());
      return var53;
   }

   @Generated
   public ai.idealistic.vacan.abstraction.b.d dp() {
      return this.gi;
   }

   @Generated
   public void n(Location var1) {
      this.gy = var1;
   }

   @Generated
   public Location dq() {
      return this.gy;
   }

   @Generated
   public void o(Location var1) {
      this.W = var1;
   }

   @Generated
   public void p(Location var1) {
      this.cX = var1;
   }

   @Generated
   public void q(Location var1) {
      this.gz = var1;
   }

   @Generated
   public Check.DataType dr() {
      return this.gI;
   }

   @Generated
   public void a(ai.idealistic.vacan.abstraction.b.b var1) {
      this.gK = var1;
   }

   @Generated
   public ai.idealistic.vacan.abstraction.check.e[] ds() {
      return this.hh;
   }

   static {
      ai.idealistic.vacan.functionality.server.c.a(() -> {
         Collection var0 = ai.idealistic.vacan.functionality.server.c.fc();
         c var2;
         if (!var0.isEmpty()) {
            for(Iterator var1 = var0.iterator(); var1.hasNext(); var2.gz = var2.getLocation()) {
               var2 = (c)var1.next();
               Check.DataType var3 = var2.gI;
               var2.gI = ai.idealistic.vacan.compatibility.b.a.c(var2.bC()) ? Check.DataType.BEDROCK : Check.DataType.JAVA;
               if (var2.gI != var3) {
                  var2.bU().h(var2);
               }

               if (!MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
                  var2.cj();
               }

               if (var2.hg[0] > 0.0D || var2.hg[1] > 0.0D || var2.hg[2] > 0.0D) {
                  var2.hf = (Entity[])var2.bC().getNearbyEntities(var2.hg[0], var2.hg[1], var2.hg[2]).toArray(new Entity[0]);
               }

               var2.cr();
               var2.co();
               var2.ca();
               var2.b(false, (Object)null);
            }
         }

      }, 1L, 1L);
   }
}
