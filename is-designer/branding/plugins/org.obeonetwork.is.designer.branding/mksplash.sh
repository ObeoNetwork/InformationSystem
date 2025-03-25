#!/bin/bash

###############################################################################
# Copyright (c) 2008, 2025 Obeo.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v2.0
# which accompanies this distribution, and is available at
# https://www.eclipse.org/legal/epl-2.0/
#
# Contributors:
#     Obeo - initial API and implementation
###############################################################################

YEAR=`date +"%Y"`
VERSION=`grep -o '<version>[0-9]\+\.[0-9]\+\.[0-9]\+-SNAPSHOT</version>' ${WORKSPACE}/releng/org.obeonetwork.informationsystem.parent/pom.xml | grep -o '[0-9]\+\.[0-9]\+\.[0-9]\+'`

echo "[INFO] Build splash screen version ${VERSION} for year ${YEAR}"

cd ${WORKSPACE}/is-designer/branding/plugins/org.obeonetwork.is.designer.branding
convert \
 -pointsize 22 -font Lato-Light -fill '#007788' -draw "text 176,206 \"Version ${VERSION}\"" \
 -pointsize 10.5 -font Lato-Regular -fill '#009DB5' -draw "text 22,316 \"© ${YEAR} Obeo. All rights reserved\"" \
 -type truecolor \
 splash.bmp BMP2:splash.bmp
