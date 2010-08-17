/*
 * Copyright (c) 2010 Sun Microsystems, Inc. All rights reserved.
 *
 * Sun Microsystems, Inc. has intellectual property rights relating to technology embodied in the product that is
 * described in this document. In particular, and without limitation, these intellectual property rights may include one
 * or more of the U.S. patents listed at http://www.sun.com/patents and one or more additional patents or pending patent
 * applications in the U.S. and in other countries.
 *
 * U.S. Government Rights - Commercial software. Government users are subject to the Sun Microsystems, Inc. standard
 * license agreement and applicable provisions of the FAR and its supplements.
 *
 * Use is subject to license terms. Sun, Sun Microsystems, the Sun logo, Java and Solaris are trademarks or registered
 * trademarks of Sun Microsystems, Inc. in the U.S. and other countries. All SPARC trademarks are used under license and
 * are trademarks or registered trademarks of SPARC International, Inc. in the U.S. and other countries.
 *
 * UNIX is a registered trademark in the U.S. and other countries, exclusively licensed through X/Open Company, Ltd.
 */
package com.sun.hotspot.c1x;

import com.sun.cri.ri.*;

/**
 * Implementation of RiMethod for HotSpot methods.
 *
 * @author Thomas Wuerthinger, Lukas Stadler
 */
public class HotSpotMethod implements RiMethod, CompilerObject {

    private final long vmId;
    private final String name;

    // cached values
    private byte[] code;
    private int accessFlags = -1;
    private int maxLocals = -1;
    private int maxStackSize = -1;
    private RiSignature signature;
    private RiType holder;

    public HotSpotMethod(long vmId, String name) {
        this.vmId = vmId;
        this.name = name;
    }

    @Override
    public int accessFlags() {
        if (accessFlags == -1) {
            accessFlags = Compiler.getVMEntries().RiMethod_accessFlags(vmId);
        }
        return accessFlags;
    }

    @Override
    public boolean canBeStaticallyBound() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public byte[] code() {
        if (code == null) {
            code = Compiler.getVMEntries().RiMethod_code(vmId);
        }
        return code;
    }

    @Override
    public RiExceptionHandler[] exceptionHandlers() {
        // TODO: Add support for exception handlers
        return new RiExceptionHandler[0];
    }

    @Override
    public boolean hasBalancedMonitors() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public RiType holder() {
        if (holder == null ) {
            holder = Compiler.getVMEntries().RiMethod_holder(vmId);
        }
        return holder;
    }

    @Override
    public boolean isClassInitializer() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isConstructor() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isLeafMethod() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isOverridden() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isResolved() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String jniSymbol() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object liveness(int bci) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int maxLocals() {
        if (maxLocals == -1) {
            maxLocals = Compiler.getVMEntries().RiMethod_maxLocals(vmId);
        }
        return maxLocals;
    }

    @Override
    public int maxStackSize() {
        if (maxStackSize == -1) {
            maxStackSize = Compiler.getVMEntries().RiMethod_maxStackSize(vmId);
        }
        return maxStackSize;
    }

    @Override
    public RiMethodProfile methodData() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public RiSignature signature() {
        if (signature == null) {
            signature = new HotSpotSignature(Compiler.getVMEntries().RiMethod_signature(vmId));
        }
        return signature;
    }

    @Override
    public String toString() {
        return "HotSpotMethod<" + name + ">";
    }

}
