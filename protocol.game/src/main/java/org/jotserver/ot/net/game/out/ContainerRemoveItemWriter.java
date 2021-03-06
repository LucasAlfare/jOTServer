package org.jotserver.ot.net.game.out;

import org.jotserver.ot.model.item.Container;
import org.jotserver.ot.model.player.Player;
import org.jotserver.ot.net.game.AbstractWriter;
import org.jotserver.ot.net.game.OTDataOutputStream;

import java.io.IOException;
import java.io.OutputStream;

public class ContainerRemoveItemWriter extends AbstractWriter {

    private int slot;
    private Container container;

    public ContainerRemoveItemWriter(Player receiver, Container container, int slot) {
        super(receiver);
        this.container = container;
        this.slot = slot;
    }

    public void write(OutputStream out) throws IOException {
        OTDataOutputStream otout = new OTDataOutputStream(out);
        otout.writeByte(0x72);
        otout.writeByte(getReceiver().getContainerId(container));
        otout.writeByte(slot);
    }
}
