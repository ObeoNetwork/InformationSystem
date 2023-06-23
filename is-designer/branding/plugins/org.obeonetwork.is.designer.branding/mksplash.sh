#!/bin/bash

###############################################################################
# Copyright (c) 2008, 2023 Obeo.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v2.0
# which accompanies this distribution, and is available at
# https://www.eclipse.org/legal/epl-2.0/
#
# Contributors:
#     Obeo - initial API and implementation
###############################################################################

YEAR=`date +"%Y"`
VERSION=`grep -o '<version>[0-9]\+\.[0-9]\+\.[0-9]\+-SNAPSHOT</version>' ${WORKSPACE}/releng/org.obeonetwork.informationsystem.parent/pom.xml | grep -o '[0-9]\+\.[0-9]\+'`

echo "[INFO] Build splash screen version ${VERSION} for year ${YEAR}"

cd ${WORKSPACE}/is-designer/branding/plugins/org.obeonetwork.is.designer.branding
convert \
 -pointsize 30 -font Liberation-Sans-Bold -fill white -draw "text 378,172 \"${VERSION}\"" \
 -pointsize 9 -font DejaVu-Sans-Bold -fill '#037788' -draw "text 275,316 \"${YEAR} Obeo - All rights reserved\"" \
 -pointsize 11 -font DejaVu-Sans-Bold -fill '#037788' -draw 'text 262,316 "©"' \
 -type truecolor \
 splash.bmp BMP2:splash.bmp
