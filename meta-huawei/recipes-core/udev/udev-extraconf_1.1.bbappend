FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGE_ARCH_angler = "${MACHINE_ARCH}"

SRC_URI_append_angler = " file://angler.rules"

do_install_append_angler() {
    install -m 0644 ${WORKDIR}/angler.rules ${D}${sysconfdir}/udev/rules.d/angler.rules
}
