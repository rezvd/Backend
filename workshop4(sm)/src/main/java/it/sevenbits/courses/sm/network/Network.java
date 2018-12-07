package it.sevenbits.courses.sm.network;

import java.util.concurrent.ConcurrentLinkedDeque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Network implements INetwork {
    private final static Logger logger = LoggerFactory.getLogger(Network.class);
    private final int maxSize;
    private ConcurrentLinkedDeque<NetworkPackage> packages = new ConcurrentLinkedDeque<NetworkPackage>();

    public Network(final int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean hasPackage() {
       return packages.size() > 0;
    }

    @Override
    public NetworkPackage getPackage(){
        if(logger.isDebugEnabled()) {
            logger.debug("Package {} was read", packages.getFirst());
        }
        return packages.removeFirst();
    }

    @Override
    public void addPackage(final String message, final String type) {
        if (packages.size() < maxSize) {
            packages.addLast(new NetworkPackage(type, message));
            if (logger.isDebugEnabled()) {
                logger.debug("Package {} was added", packages.getLast());
            }
        } else {
            if (logger.isErrorEnabled()) {
                logger.error("Max size {} was reached", maxSize);
            }
        }
    }
}
