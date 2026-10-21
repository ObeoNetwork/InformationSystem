# Sirius JPEG fix for ISD 6.0

This module fixes empty JPEG exports from Sirius diagrams, which also affect document generation with M2Doc. It builds a patched `org.eclipse.sirius.diagram.ui` bundle from Sirius revision `b1d8acf3e355f1d533ff7fafcaf6dd95fa8d05dd`.

Upstream reference: [Sirius PR #735](https://github.com/eclipse-sirius/sirius-desktop/pull/735).

## Patches

The build applies two patches in order:

1. `jpeg-fix.patch`: the Sirius team's fix, replacing SWT JPEG encoding with Java ImageIO.
2. `jpeg-fix-hardening.patch`: explicit reporting when no JPEG encoder is available, propagation of write errors and resource cleanup. The output stream supplied by the caller remains open.

Transparent images are flattened onto a white background. ImageIO's default JPEG encoding parameters are retained, and image dimensions are unchanged.

## Build

The module is included in the existing repository build: `clean verify` on `releng/org.obeonetwork.informationsystem.parent/pom.xml`.

The build:

1. Downloads the pinned Sirius source archive and verifies its SHA-256 checksum.
2. Extracts only `org.eclipse.sirius.diagram.ui` under `target/upstream`.
3. Checks and applies each patch with `git apply`.
4. Compiles the plugin with Tycho and produces the binary and matching source bundle.

Git must be available on the build agent PATH. Archives are cached under `${settings.localRepository}/.cache/isd-sirius`. A checksum mismatch or patch failure stops the build. `GIT_CEILING_DIRECTORIES` prevents Git from discovering the enclosing ISD repository.

The bundle retains the upstream Java 17 execution requirement and compilation level. Its version is `7.5.0.isd60jpeg1`. The manifest and build metadata are stored alongside the recipe because Tycho reads them before source preparation.

## Product integration

The existing ISD p2 repository publishes an assembly feature containing the corrected binary, its sources and two feature patches. These patches replace the bundle required by `org.eclipse.sirius.runtime.ide.ui` and `org.eclipse.sirius.specifier`, both at version `7.5.0.202601281512`.

The required original Sirius features and bundles are also copied unchanged into the repository. CE and TE include the assembly feature in all distributions.

## Maintenance

Increase the bundle version qualifier whenever the source revision or patches change. Review the exact feature patch scopes when updating the Sirius base.

Once the Sirius base includes the fix, remove these temporary modules, their repository entry and their product and target platform references.
