SUMMARY = "A tool to read/write/update android boot images"
HOMEPAGE = "https://github.com/luchachen/abootimg"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "util-linux"

PV = "0.6+gitr${SRCPV}"

SRC_URI = "git://github.com/luchachen/abootimg;protocol=git;branch=master"
SRCREV = "9f5df7eefa42acf2b10236878542875a3b477e9d"
S = "${WORKDIR}/git"

EXTRA_OEMAKE = "-e MAKEFLAGS="

BBCLASSEXTEND = "native"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/abootimg ${D}${bindir}
    install -m 0755 ${S}/abootimg-pack-initrd ${D}${bindir}
    install -m 0755 ${S}/abootimg-unpack-initrd ${D}${bindir}
}
