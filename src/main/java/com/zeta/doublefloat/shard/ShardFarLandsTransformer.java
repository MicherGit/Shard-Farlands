package com.zeta.doublefloat.shard;

import com.thistestuser.farlands.Config;
import net.minecraft.launchwrapper.IClassTransformer;
import org.apache.logging.log4j.LogManager;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;

import java.util.ArrayList;
import java.util.List;

public class ShardFarLandsTransformer implements IClassTransformer
{

	@Override
	public byte[] transform(String name, String transformedName, byte[] basicClass) {
		return new byte[0];
	}

	public byte[] patch(String name, byte[] classBytes) {
		ClassNode classNode = new ClassNode();
		ClassReader classReader = new ClassReader(classBytes);
		classReader.accept(classNode, 0);

		boolean pass = false;
		for(MethodNode method : classNode.methods)
			if(method.desc.equals("([DIIIIIIDDD)[D"))
				for(AbstractInsnNode ain : method.instructions.toArray())
					if(ain.getOpcode() == Opcodes.LDC
							&& ((LdcInsnNode)ain).cst instanceof Long && (Long)((LdcInsnNode)ain).cst == 16777216L)
					{
						((LdcInsnNode)ain).cst = Long.MAX_VALUE;
						pass = true;
					}
		if(pass)
			LogManager.getLogger().info("[FarLands] Noise generator patched successfully!");

		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		classNode.accept(classWriter);
		return classWriter.toByteArray();
	}
}
