package ai.idealistic.vacan.listeners.protocol;

import ai.idealistic.vacan.Register;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.WrappedBlockData;
import org.bukkit.entity.Player;

public class k extends PacketAdapter {
   public k() {
      super(Register.plugin, ListenerPriority.NORMAL, new PacketType[]{Server.BLOCK_CHANGE});
   }

   public void onPacketSending(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var2);
      PacketContainer var4 = var1.getPacket();
      BlockPosition var5 = (BlockPosition)var4.getBlockPositionModifier().read(0);
      WrappedBlockData var6 = (WrappedBlockData)var4.getBlockData().read(0);
      ai.idealistic.vacan.abstraction.d.j var7 = new ai.idealistic.vacan.abstraction.d.j(var5, var6.getType());
      var3.gL.a(var7);
   }
}
