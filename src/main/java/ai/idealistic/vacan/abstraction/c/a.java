package ai.idealistic.vacan.abstraction.c;

import ai.idealistic.vacan.abstraction.f.c;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import ai.idealistic.vacan.utils.minecraft.a.b;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ArmorStand.LockType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

public class a {
   public static final boolean fn;
   public static final boolean fo;
   private static final OfflinePlayer fp;
   private static final String fq = "IdealisticAI";
   public final ArmorStand fr;
   public final Location W;
   private double fs;
   private double ft;

   public a(Location var1) {
      Location var2 = var1.clone();
      var2.setX((double)var2.getBlockX() + 0.5D);
      var2.setZ((double)var2.getBlockZ() + 0.5D);
      this.W = var2;
      this.fr = (ArmorStand)var2.getWorld().spawnEntity(var2, EntityType.ARMOR_STAND);
      this.fr.setGravity(false);
      this.fr.setSmall(false);
      this.fr.setVisible(false);
      this.fr.setCustomName("§2Vacan §cAnti§4Cheat");
      this.fr.setCustomNameVisible(true);
      this.fr.setArms(true);
      if (fo) {
         this.fr.addEquipmentLock(EquipmentSlot.HEAD, LockType.REMOVING_OR_CHANGING);
         this.fr.addEquipmentLock(EquipmentSlot.CHEST, LockType.REMOVING_OR_CHANGING);
         this.fr.addEquipmentLock(EquipmentSlot.LEGS, LockType.REMOVING_OR_CHANGING);
         this.fr.addEquipmentLock(EquipmentSlot.FEET, LockType.REMOVING_OR_CHANGING);
         this.fr.addEquipmentLock(EquipmentSlot.HAND, LockType.REMOVING_OR_CHANGING);
         this.fr.addEquipmentLock(EquipmentSlot.OFF_HAND, LockType.REMOVING_OR_CHANGING);
      }

      if (fn) {
         this.fr.getEquipment().setItemInOffHand(new ItemStack(Material.SHIELD));
      }

      this.bk();
      this.bl();
      ItemStack var3 = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta var4 = (LeatherArmorMeta)var3.getItemMeta();
      var4.setColor(Color.RED);
      var3.setItemMeta(var4);
      this.fr.getEquipment().setChestplate(var3);
      this.fr.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
      var3 = new ItemStack(Material.LEATHER_BOOTS);
      var4 = (LeatherArmorMeta)var3.getItemMeta();
      var4.setColor(Color.GRAY);
      var3.setItemMeta(var4);
      this.fr.getEquipment().setBoots(var3);
      var3 = new ItemStack(Material.IRON_SWORD);
      var3.addEnchantment(b.lI, 1);
      this.fr.getEquipment().setItemInHand(var3);
   }

   private void bk() {
      this.fr.setBodyPose(new EulerAngle(0.0D, 0.0D, 0.0D));
      this.fr.setRightLegPose(new EulerAngle(0.0D, 0.0D, Math.toRadians(5.0D)));
      this.fr.setLeftLegPose(new EulerAngle(0.0D, 0.0D, -Math.toRadians(5.0D)));
   }

   public boolean a(List<c> var1) {
      if (this.fr.isDead()) {
         return false;
      } else {
         this.bk();
         double var2 = 5.0D;
         double var4 = 15.0D;
         if (this.ft >= var2) {
            this.ft = -var2;
         }

         this.ft += 0.1D;
         if (this.fs >= var4) {
            this.fs = -var4;
         }

         this.fs += 0.25D;
         this.fr.getWorld().playEffect(this.fr.getLocation().clone().add(0.0D, Math.ceil(this.fr.getEyeHeight()) * 2.0D, 0.0D), Effect.ENDER_SIGNAL, 16);
         this.fr.setHeadPose(new EulerAngle(Math.toRadians(Math.abs(this.ft)), 0.0D, 0.0D));
         this.fr.setRightArmPose(new EulerAngle(0.0D, 0.0D, Math.toRadians(Math.abs(this.fs))));
         this.fr.setLeftArmPose(new EulerAngle(0.0D, 0.0D, -Math.toRadians(Math.abs(this.fs))));
         c var6 = null;
         Iterator var7 = var1.iterator();

         while(true) {
            c var8;
            do {
               if (!var7.hasNext()) {
                  Vector var10 = var6.getLocation().toVector();
                  Vector var11 = this.fr.getLocation().toVector();
                  Vector var9 = var10.subtract(var11);
                  this.fr.teleport(this.fr.getLocation().setDirection(var9));
                  return true;
               }

               var8 = (c)var7.next();
            } while(var6 != null && !(ai.idealistic.vacan.abstraction.g.b.b(var8.bO(), this.W) < ai.idealistic.vacan.abstraction.g.b.b(var6.bO(), this.W)));

            var6 = var8;
         }
      }
   }

   public void bl() {
      ai.idealistic.vacan.functionality.b.a.b(() -> {
         this.fr.getEquipment().setHelmet(ai.idealistic.vacan.utils.minecraft.a.c.b(fp, "IdealisticAI", true));
      });
   }

   public void bm() {
      this.fr.remove();
   }

   public UUID bn() {
      return this.fr.getUniqueId();
   }

   static {
      fn = MultiVersion.c(MultiVersion.MCVersion.V1_9);
      fo = MultiVersion.c(MultiVersion.MCVersion.V1_16);
      fp = Bukkit.getOfflinePlayer(UUID.fromString("0e6f8837-3b61-4e42-b91c-81c0222bafd9"));
   }
}
