package ai.idealistic.vacan.compatibility.b.a;

import ai.idealistic.vacan.functionality.server.MultiVersion;
import ai.idealistic.vacan.listeners.protocol.MovementListener;
import ai.idealistic.vacan.listeners.protocol.d;
import ai.idealistic.vacan.listeners.protocol.e;
import ai.idealistic.vacan.listeners.protocol.f;
import ai.idealistic.vacan.listeners.protocol.g;
import ai.idealistic.vacan.listeners.protocol.i;
import ai.idealistic.vacan.listeners.protocol.j;
import ai.idealistic.vacan.listeners.protocol.k;
import ai.idealistic.vacan.listeners.protocol.l;
import ai.idealistic.vacan.listeners.protocol.m;
import ai.idealistic.vacan.listeners.protocol.n;
import ai.idealistic.vacan.listeners.protocol.o;
import ai.idealistic.vacan.listeners.protocol.p;
import ai.idealistic.vacan.listeners.protocol.q;
import ai.idealistic.vacan.listeners.protocol.b.c;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.PacketType.Play.Client;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a {
   private static final List<String> hZ = new ArrayList();

   static boolean F(String var0) {
      return hZ.contains(var0);
   }

   private static void et() {
      Iterator var0 = Client.getInstance().iterator();

      while(var0.hasNext()) {
         PacketType var1 = (PacketType)var0.next();
         hZ.add(var1.name());
      }

   }

   static void run() {
      et();
      ProtocolManager var0 = ProtocolLibrary.getProtocolManager();
      var0.addPacketListener(new c());
      var0.addPacketListener(new ai.idealistic.vacan.listeners.protocol.b.b());
      var0.addPacketListener(new q());
      if (MultiVersion.c(MultiVersion.MCVersion.V1_17)) {
         var0.addPacketListener(new ai.idealistic.vacan.listeners.protocol.a.a());
      } else {
         var0.addPacketListener(new ai.idealistic.vacan.listeners.protocol.a.b());
      }

      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         var0.addPacketListener(new g());
      } else {
         var0.addPacketListener(new f());
      }

      var0.addPacketListener(new MovementListener());
      var0.addPacketListener(new l());
      var0.addPacketListener(new p());
      var0.addPacketListener(new d());
      var0.addPacketListener(new ai.idealistic.vacan.listeners.protocol.b());
      var0.addPacketListener(new ai.idealistic.vacan.listeners.protocol.c());
      var0.addPacketListener(new j());
      var0.addPacketListener(new e());
      var0.addPacketListener(new k());
      var0.addPacketListener(new i());
      var0.addPacketListener(new ai.idealistic.vacan.listeners.protocol.a());
      var0.addPacketListener(new o());
      var0.addPacketListener(new n());
      if (ai.idealistic.vacan.utils.minecraft.entity.d.dl) {
         var0.addPacketListener(new m());
      }

   }
}
