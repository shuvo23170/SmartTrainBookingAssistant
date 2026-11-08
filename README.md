# Smart Train Booking Assistant (Android prototype)

A starter Android Studio project for an assisted Bangladesh Railway ticket-booking workflow.

## Current prototype features
- Editable origin, destination, journey date, preferred train and passenger count.
- Opens the official Bangladesh Railway e-ticket website in Google Chrome when available.
- Copies trip details to the clipboard for convenient entry.
- Does not collect railway credentials, automate CAPTCHA/OTP, reserve seats, or make payments.

## Build an APK with Android Studio
1. Install Android Studio (latest stable) and Android SDK 35.
2. Open this folder in Android Studio.
3. Allow Gradle sync.
4. Select **Build > Build Bundle(s) / APK(s) > Build APK(s)**.
5. The debug APK is created at `app/build/outputs/apk/debug/app-debug.apk`.

## Build an APK in GitHub Actions (no local Android SDK required)
1. Extract this ZIP on a computer.
2. Create a new GitHub repository and upload the contents of this folder to its `main` branch.
3. Open the repository's **Actions** tab and select **Build Android APK**.
4. Run the workflow if it has not started automatically.
5. When successful, open the completed workflow run and download the `SmartTrainAssistant-debug-apk` artifact. Extract it to get `app-debug.apk`.
6. Transfer the APK to your Android phone and install it. Android may ask you to allow installation from that source.

## Important limitations
This is a starter prototype, not a completed booking bot. It opens the official railway website and helps prepare/copy trip details. It does not automate booking, bypass CAPTCHA/OTP, reserve seats, or make payments. The railway website controls actual availability, booking, payment deadlines and whether an unpaid seat is held. Keep credentials, OTP, CAPTCHA and payment under your control.
