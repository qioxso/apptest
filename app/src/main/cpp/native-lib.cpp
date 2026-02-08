#include <jni.h>
#include <string>

extern "C" JNIEXPORT jint JNICALL
Java_com_example_simplejni_MainActivity_nativeAdd(
        JNIEnv* env,
        jobject /* this */,
        jint value) {
    // 核心逻辑：传入的数字 +1
    return value + 1;
}
