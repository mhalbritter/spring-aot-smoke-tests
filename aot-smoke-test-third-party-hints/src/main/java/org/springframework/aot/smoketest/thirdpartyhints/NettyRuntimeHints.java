package org.springframework.aot.smoketest.thirdpartyhints;

import java.net.ProtocolFamily;
import java.nio.channels.spi.SelectorProvider;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeReference;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

/**
 * @author Moritz Halbritter
 */
// TODO: Contribute / use netty hints from graalvm reachability repo!
public class NettyRuntimeHints implements RuntimeHintsRegistrar {

	@Override
	public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
		if (!ClassUtils.isPresent("io.netty.util.NettyRuntime", classLoader)) {
			return;
		}
		hints.reflection().registerType(TypeReference.of("io.netty.buffer.AbstractByteBufAllocator"),
				hint -> hint.withMembers(MemberCategory.INTROSPECT_DECLARED_METHODS));
		hints.reflection().registerType(TypeReference.of("io.netty.util.ReferenceCountUtil"),
				hint -> hint.withMembers(MemberCategory.INTROSPECT_DECLARED_METHODS));
		hints.reflection().registerType(
				TypeReference.of("io.netty.util.internal.shaded.org.jctools.maps.NonBlockingHashMap"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(
				TypeReference.of("io.netty.util.internal.shaded.org.jctools.maps.NonBlockingHashMapLong"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(
				TypeReference.of("io.netty.util.internal.shaded.org.jctools.maps.NonBlockingSetInt"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(
				TypeReference.of("io.netty.util.internal.shaded.org.jctools.maps.NonBlockingSetInt$NBSI"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(
				TypeReference.of("io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueueConsumerNodeRef"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(
				TypeReference.of("io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueueProducerNodeRef"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection()
				.registerType(TypeReference.of(
						"io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueueColdProducerFields"),
						hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection()
				.registerType(TypeReference
						.of("io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueueConsumerFields"),
						hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection()
				.registerType(TypeReference
						.of("io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueueProducerFields"),
						hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection()
				.registerType(TypeReference
						.of("io.netty.util.internal.shaded.org.jctools.queues.BaseSpscLinkedArrayQueueConsumerField"),
						hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection()
				.registerType(TypeReference
						.of("io.netty.util.internal.shaded.org.jctools.queues.BaseSpscLinkedArrayQueueProducerFields"),
						hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(
				TypeReference.of("io.netty.util.internal.shaded.org.jctools.queues.LinkedQueueNode"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(
				TypeReference.of("io.netty.util.internal.shaded.org.jctools.queues.MpmcArrayQueueConsumerIndexField"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(
				TypeReference.of("io.netty.util.internal.shaded.org.jctools.queues.MpmcArrayQueueProducerIndexField"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(
				TypeReference.of("io.netty.util.internal.shaded.org.jctools.queues.MpscArrayQueueConsumerIndexField"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(
				TypeReference.of("io.netty.util.internal.shaded.org.jctools.queues.MpscArrayQueueProducerIndexField"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(
				TypeReference.of("io.netty.util.internal.shaded.org.jctools.queues.MpscArrayQueueProducerLimitField"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(TypeReference.of(
				"io.netty.util.internal.shaded.org.jctools.queues.MpscBlockingConsumerArrayQueueColdProducerFields"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(TypeReference
				.of("io.netty.util.internal.shaded.org.jctools.queues.MpscBlockingConsumerArrayQueueConsumerFields"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(TypeReference
				.of("io.netty.util.internal.shaded.org.jctools.queues.MpscBlockingConsumerArrayQueueProducerFields"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection()
				.registerType(TypeReference
						.of("io.netty.util.internal.shaded.org.jctools.queues.MpUnboundedXaddArrayQueueConsumerFields"),
						hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection()
				.registerType(TypeReference
						.of("io.netty.util.internal.shaded.org.jctools.queues.MpUnboundedXaddArrayQueueProducerChunk"),
						hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection()
				.registerType(TypeReference
						.of("io.netty.util.internal.shaded.org.jctools.queues.MpUnboundedXaddArrayQueueProducerFields"),
						hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(
				TypeReference.of("io.netty.util.internal.shaded.org.jctools.queues.MpUnboundedXaddChunk"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(
				TypeReference.of("io.netty.util.internal.shaded.org.jctools.queues.SpmcArrayQueueConsumerIndexField"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(
				TypeReference.of("io.netty.util.internal.shaded.org.jctools.queues.SpmcArrayQueueProducerIndexField"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(
				TypeReference.of("io.netty.util.internal.shaded.org.jctools.queues.SpscArrayQueueConsumerIndexField"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(
				TypeReference.of("io.netty.util.internal.shaded.org.jctools.queues.SpscArrayQueueProducerIndexFields"),
				hint -> hint.withMembers(MemberCategory.DECLARED_FIELDS));
		hints.reflection().registerType(TypeReference.of("io.netty.channel.socket.nio.NioSocketChannel"),
				hint -> hint.withMembers(MemberCategory.INVOKE_DECLARED_CONSTRUCTORS));
		hints.reflection().registerType(TypeReference.of("io.netty.channel.socket.nio.NioDatagramChannel"),
				hint -> hint.withMembers(MemberCategory.INVOKE_DECLARED_CONSTRUCTORS));
		hints.reflection().registerType(TypeReference.of("io.netty.channel.DefaultChannelPipeline$TailContext"),
				hint -> hint.withMembers(MemberCategory.INVOKE_DECLARED_METHODS));
		hints.reflection().registerType(TypeReference.of("io.netty.channel.DefaultChannelPipeline$HeadContext"),
				hint -> hint.withMembers(MemberCategory.INVOKE_DECLARED_METHODS));
		hints.reflection().registerType(TypeReference.of("io.netty.handler.codec.http.HttpServerCodec"),
				hint -> hint.withMembers(MemberCategory.INVOKE_PUBLIC_METHODS));
		hints.reflection().registerType(TypeReference.of("io.netty.handler.codec.dns.DatagramDnsQueryEncoder"),
				hint -> hint.withMembers(MemberCategory.INVOKE_PUBLIC_METHODS));
		hints.reflection().registerMethod(
				ReflectionUtils.findMethod(SelectorProvider.class, "openSocketChannel", ProtocolFamily.class));
		hints.reflection().registerMethod(
				ReflectionUtils.findMethod(SelectorProvider.class, "openServerSocketChannel", ProtocolFamily.class));
		hints.reflection().registerType(TypeReference.of("java.nio.DirectByteBuffer"),
				hint -> hint.withMembers(MemberCategory.INVOKE_DECLARED_CONSTRUCTORS));
	}

}
