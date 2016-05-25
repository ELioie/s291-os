LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_SRC_FILES := \
	Hash.c \
	SysUtil.c \
	DirUtil.c \
	Inlines.c \
	Zip.c

LOCAL_C_INCLUDES := \
	external/zlib \
	external/safe-iop/include \
	external/lzma/xz-embedded

LOCAL_STATIC_LIBRARIES := libselinux
LOCAL_STATIC_LIBRARIES += libxz

LOCAL_MODULE := libminzip

LOCAL_CFLAGS += -Wall

include $(BUILD_STATIC_LIBRARY)

#added by tiger libminzip.so is need by other module
##################################################
include $(CLEAR_VARS)

LOCAL_SRC_FILES := \
	DirUtil.c \

LOCAL_C_INCLUDES += \
	external/zlib \
	external/safe-iop/include
LOCAL_C_INCLUDES += external/libselinux/include
LOCAL_STATIC_LIBRARIES += libselinux
LOCAL_CFLAGS += -DHAVE_SELINUX
LOCAL_MODULE := libminzip

LOCAL_CFLAGS += -Wall

include $(BUILD_SHARED_LIBRARY)
