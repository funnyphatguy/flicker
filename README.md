# Flicker

A swipe-based Android app for two people to decide on a movie to watch together. Both partners set shared filters, take turns swiping cards on the same device, and end up with a list of mutual likes — matches.

## Overview

Picking a movie with another person usually involves either scrolling through endless catalog pages or arguing through it. Flicker reduces that to a 30-second filter setup followed by independent swiping — the app surfaces only the titles both partners liked.

The current scope implements a single-device flow ("pass-the-phone"): one partner swipes through the entire queue, then hands the phone over. No accounts, no backend, no cross-device sync.

## Features

- Pre-session filtering: genres (multi-select), year range, minimum rating
- Swipe gesture with smooth dismissal animations
- Shared queue across both partners (deterministic shuffle via session seed)
- Match detection across the session
- Results screen with all mutual likes
- Graceful handling of empty states, network errors, and exhausted queues

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Kotlin |
| UI | Jetpack Compose |
| Dependency Injection | Dagger 2 |
| UI Architecture | MVI on top of ViewModel (State / Action / Event) |
| Networking | Retrofit + Kotlinx Serialization |
| Local Storage | Room |
| Image Loading | Coil |
| CI | GitHub Actions |

**Data source:** [Kinopoisk.dev](https://kinopoisk.dev) — `/v1.4/movie` endpoint with multi-criteria filtering.

## Architecture

Multi-module project with clear separation between core utilities, data sources, and feature screens.

```
:app
:core:core              — base utilities, shared domain models
:core:ui:kit            — theme, colors, base composables
:core:data:network      — Retrofit, DTOs, mappers
:core:data:database     — Room
:feature:filter         — filters screen
:feature:swipe          — swipe screen
:feature:results        — results screen
```

**Dependency rules:**
- `feature` modules depend on `core` modules
- `core` modules never depend on `feature` modules
- `feature` modules never depend on each other — shared logic is lifted into `core`

The `api/impl` split is intentionally avoided at this scale — it adds ceremony without meaningful boundary enforcement for the project size.

## Getting Started

### Prerequisites

- Android Studio (latest stable)
- JDK 21
- Android SDK 26+ (Android 8.0)

### API Key

1. Register at [kinopoisk.dev](https://kinopoisk.dev) to obtain an API key.
2. Add the key to your `local.properties` file:

   ```properties
   KINOPOISK_API_KEY="your_key_here"
   ```

### Build

```bash
./gradlew assembleDebug
```

To install on a connected device or running emulator:

```bash
./gradlew build
```

## Roadmap

- [ ] **MVP1** — pass-the-phone mechanic, basic filters, swipe, in-session matches. No backend.
- [ ] **MVP2** — two-device mode with real-time sync (Firebase or self-hosted backend).
- [ ] **MVP3** — streaming availability via `watchability` field, per-service filtering.
- [ ] **Beyond** — recommendation logic based on swipe history.
