DESCRIPTION = "intone is a mplayer frontend for openmoko phones"
HOMEPAGE = "http://code.google.com/p/intone/"
AUTHOR = "cchandel"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "files://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"
SECTION = "e/apps"
DEPENDS = "elementary eina sqlite3 dbus edbus libvorbis id3lib"
RDEPENDS_${PN} = "mplayer lame libxv libsdl-x11"

SRCREV = "76"
PV = "0.66+svnr${SRCPV}"
PR = "r13"

SRC_URI = "svn://intone.googlecode.com/svn;module=trunk;proto=http \
file://vorbis-include-id3tag.patch;maxrev=18 \
file://0001-adapt-to-newer-elementary-API.patch \
file://depends.eina.patch"

S = "${WORKDIR}/trunk"

inherit autotools

do_install_append() {
	mkdir -p "${D}/${datadir}/pixmaps"
	install -m 0644 "${S}/resources/intone.png" "${D}/${datadir}/pixmaps"
	mkdir -p "${D}/${datadir}/applications"
	install -m 0644 "${S}/resources/intone.desktop" "${D}/${datadir}/applications"
	mkdir -p "${D}/${datadir}/intone"
	for ico in "${S}/resources/"*.png; do
		if [ "$(basename $ico)" != "intone.png" ]; then
			install -m 0644 $ico "${D}/${datadir}/intone"
		fi
	done
}


FILES_${PN} += "/usr/share/intone/* /usr/share/applications/* /usr/share/pixmaps/*"

