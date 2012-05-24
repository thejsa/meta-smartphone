require ${BPN}.inc

PR = "${INC_PR}.0"

SRC_URI[md5sum] = "9d98ea525d674e95d9c9eb9b61c5e56c"
SRC_URI[sha256sum] = "1739272732185b73bab9018117f6545055f6a39f54bb8ce9a8b1bd91b01c777e"

# work around for missing file in release dist
SRC_URI += "file://samsung_modem_ctl.h"

do_compile_prepend() {
  mkdir -p ${S}/src/plugins/modem_samsung/include
  cp ${WORKDIR}/samsung_modem_ctl.h ${S}/src/plugins/modem_samsung/include/
}
