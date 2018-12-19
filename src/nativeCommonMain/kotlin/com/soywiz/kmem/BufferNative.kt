// @WARNING: File AUTOGENERATED by `korlibs-generator-jvm/src/com/soywiz/korlibs` @ korlibs/kmem do not modify manually!
// @TODO: USELESS_CAST is required since it requires a cast to work, but IDE says that that cast is not necessary
@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER", "RedundantUnitReturnType", "FunctionName", "USELESS_CAST")
package com.soywiz.kmem

import com.soywiz.kmem.internal.*

actual class MemBuffer(val data: ByteArray)
actual fun MemBufferAlloc(size: Int): MemBuffer = MemBuffer(ByteArray(size))
actual fun MemBufferAllocNoDirect(size: Int): MemBuffer = MemBuffer(ByteArray(size))
actual fun MemBufferWrap(array: ByteArray): MemBuffer = MemBuffer(array)
actual inline val MemBuffer.size: Int get() = data.size

actual fun MemBuffer._sliceInt8Buffer(offset: Int, size: Int): Int8Buffer =
    Int8Buffer(this, offset * 1, size)
actual fun MemBuffer._sliceInt16Buffer(offset: Int, size: Int): Int16Buffer =
    Int16Buffer(this, offset * 2, size)
actual fun MemBuffer._sliceInt32Buffer(offset: Int, size: Int): Int32Buffer =
    Int32Buffer(this, offset * 4, size)
actual fun MemBuffer._sliceFloat32Buffer(offset: Int, size: Int): Float32Buffer =
    Float32Buffer(this, offset * 4, size)
actual fun MemBuffer._sliceFloat64Buffer(offset: Int, size: Int): Float64Buffer =
    Float64Buffer(this, offset * 8, size)

actual typealias DataBuffer = MemBuffer
actual val DataBuffer.mem: MemBuffer get() = this
actual fun MemBuffer.getData(): DataBuffer = this
actual fun DataBuffer.getByte(index: Int): Byte = data.get(index)
actual fun DataBuffer.getShort(index: Int): Short = data.getShortAt(index)
actual fun DataBuffer.getInt(index: Int): Int = data.getIntAt(index)
actual fun DataBuffer.getFloat(index: Int): Float = data.getFloatAt(index)
actual fun DataBuffer.getDouble(index: Int): Double = data.getDoubleAt(index)
actual fun DataBuffer.setByte(index: Int, value: Byte): Unit = data.set(index, value)
actual fun DataBuffer.setShort(index: Int, value: Short): Unit = data.setShortAt(index, value)
actual fun DataBuffer.setInt(index: Int, value: Int): Unit = data.setIntAt(index, value)
actual fun DataBuffer.setFloat(index: Int, value: Float): Unit = data.setFloatAt(index, value)
actual fun DataBuffer.setDouble(index: Int, value: Double): Unit = data.setDoubleAt(index, value)

actual class Int8Buffer(val mbuffer: MemBuffer, val byteOffset: Int, val size: Int) {
    companion object {
        const val SIZE = 1
    }
    val MOFFSET = byteOffset / SIZE
    val MSIZE = size / SIZE
    fun getByteIndex(index: Int) = byteOffset + index * SIZE
}
actual val Int8Buffer.mem: MemBuffer get() = mbuffer
actual val Int8Buffer.offset: Int get() = MOFFSET
actual val Int8Buffer.size: Int get() = MSIZE
actual operator fun Int8Buffer.get(index: Int): Byte = mbuffer.getByte(getByteIndex(index))
actual operator fun Int8Buffer.set(index: Int, value: Byte): Unit = mbuffer.setByte(getByteIndex(index), value)

actual class Int16Buffer(val mbuffer: MemBuffer, val byteOffset: Int, val size: Int) {
    companion object {
        const val SIZE = 2
    }
    val MOFFSET = byteOffset / SIZE
    val MSIZE = size / SIZE
    fun getByteIndex(index: Int) = byteOffset + index * SIZE
}
actual val Int16Buffer.mem: MemBuffer get() = mbuffer
actual val Int16Buffer.offset: Int get() = MOFFSET
actual val Int16Buffer.size: Int get() = MSIZE
actual operator fun Int16Buffer.get(index: Int): Short = mbuffer.getShort(getByteIndex(index))
actual operator fun Int16Buffer.set(index: Int, value: Short): Unit = mbuffer.setShort(getByteIndex(index), value)

actual class Int32Buffer(val mbuffer: MemBuffer, val byteOffset: Int, val size: Int) {
    companion object {
        const val SIZE = 4
    }
    val MOFFSET = byteOffset / SIZE
    val MSIZE = size / SIZE
    fun getByteIndex(index: Int) = byteOffset + index * SIZE
}
actual val Int32Buffer.mem: MemBuffer get() = mbuffer
actual val Int32Buffer.offset: Int get() = MOFFSET
actual val Int32Buffer.size: Int get() = MSIZE
actual operator fun Int32Buffer.get(index: Int): Int = mbuffer.getInt(getByteIndex(index))
actual operator fun Int32Buffer.set(index: Int, value: Int): Unit = mbuffer.setInt(getByteIndex(index), value)

actual class Float32Buffer(val mbuffer: MemBuffer, val byteOffset: Int, val size: Int) {
    companion object {
        const val SIZE = 4
    }
    val MOFFSET = byteOffset / SIZE
    val MSIZE = size / SIZE
    fun getByteIndex(index: Int) = byteOffset + index * SIZE
}
actual val Float32Buffer.mem: MemBuffer get() = mbuffer
actual val Float32Buffer.offset: Int get() = MOFFSET
actual val Float32Buffer.size: Int get() = MSIZE
actual operator fun Float32Buffer.get(index: Int): Float = mbuffer.getFloat(getByteIndex(index))
actual operator fun Float32Buffer.set(index: Int, value: Float): Unit = mbuffer.setFloat(getByteIndex(index), value)

actual class Float64Buffer(val mbuffer: MemBuffer, val byteOffset: Int, val size: Int) {
    companion object {
        const val SIZE = 8
    }
    val MOFFSET = byteOffset / SIZE
    val MSIZE = size / SIZE
    fun getByteIndex(index: Int) = byteOffset + index * SIZE
}
actual val Float64Buffer.mem: MemBuffer get() = mbuffer
actual val Float64Buffer.offset: Int get() = MOFFSET
actual val Float64Buffer.size: Int get() = MSIZE
actual operator fun Float64Buffer.get(index: Int): Double = mbuffer.getDouble(getByteIndex(index))
actual operator fun Float64Buffer.set(index: Int, value: Double): Unit = mbuffer.setDouble(getByteIndex(index), value)

actual fun arraycopy(src: MemBuffer, srcPos: Int, dst: MemBuffer, dstPos: Int, size: Int): Unit = arraycopy(src.data, srcPos, dst.data, dstPos, size)
actual fun arraycopy(src: ByteArray, srcPos: Int, dst: MemBuffer, dstPos: Int, size: Int): Unit = arraycopy(src, srcPos, dst.data, dstPos, size)
actual fun arraycopy(src: MemBuffer, srcPos: Int, dst: ByteArray, dstPos: Int, size: Int): Unit = arraycopy(src.data, srcPos, dst, dstPos, size)
actual fun arraycopy(src: ShortArray, srcPos: Int, dst: MemBuffer, dstPos: Int, size: Int): Unit = arraycopyBase(src, srcPos, dst, dstPos, size) { s, d -> dst.setShort(d * 2, src[s]) }
actual fun arraycopy(src: IntArray, srcPos: Int, dst: MemBuffer, dstPos: Int, size: Int): Unit = arraycopyBase(src, srcPos, dst, dstPos, size) { s, d -> dst.setInt(d * 4, src[s]) }
actual fun arraycopy(src: FloatArray, srcPos: Int, dst: MemBuffer, dstPos: Int, size: Int): Unit = arraycopyBase(src, srcPos, dst, dstPos, size) { s, d -> dst.setFloat(d * 4, src[s]) }
actual fun arraycopy(src: DoubleArray, srcPos: Int, dst: MemBuffer, dstPos: Int, size: Int): Unit = arraycopyBase(src, srcPos, dst, dstPos, size) { s, d -> dst.setDouble(d * 8, src[s]) }
actual fun arraycopy(src: MemBuffer, srcPos: Int, dst: ShortArray, dstPos: Int, size: Int): Unit = arraycopyBase(src, srcPos, dst, dstPos, size) { s, d -> dst[d] = src.getShort(s * 2) }
actual fun arraycopy(src: MemBuffer, srcPos: Int, dst: IntArray, dstPos: Int, size: Int): Unit = arraycopyBase(src, srcPos, dst, dstPos, size) { s, d -> dst[d] = src.getInt(s * 4) }
actual fun arraycopy(src: MemBuffer, srcPos: Int, dst: FloatArray, dstPos: Int, size: Int): Unit = arraycopyBase(src, srcPos, dst, dstPos, size) { s, d -> dst[d] = src.getFloat(s * 4) }
actual fun arraycopy(src: MemBuffer, srcPos: Int, dst: DoubleArray, dstPos: Int, size: Int): Unit = arraycopyBase(src, srcPos, dst, dstPos, size) { s, d -> dst[d] = src.getDouble(s * 8) }