# Local Port Scanner

Local Port Scanner is a simple Java command-line tool that checks which ports are open on a host provided by the user.

This project is intended as a beginner-friendly networking and cybersecurity exercise. It focuses on learning how sockets, ports, and local services work in a safe lab environment.

## Features

- Accepts the target host as a command-line argument
- Asks for the target host interactively if no argument is provided
- Checks ports from `1` to `1024`
- Prints only open ports
- Uses a connection timeout to avoid waiting too long on closed ports
- Runs locally and does not require external libraries

## Project Structure

```text
local-port-scanner/
  src/
    PortScanner.java
  README.md
  LICENSE
```

## Requirements

- Java JDK installed

You can check your Java installation with:

```bash
java -version
javac -version
```

## Usage

Compile the program:

```bash
javac -d out src/PortScanner.java
```

Run it in interactive mode:

```bash
java -cp out PortScanner
```

Then enter a host when prompted:

```text
Enter host to scan:
localhost
```

Or pass the host directly as an argument:

```bash
java -cp out PortScanner localhost
```

You can also use a local or lab IP address that you own or have permission to scan:

```bash
java -cp out PortScanner 127.0.0.1
```

Example output on Windows:

```text
Enter host to scan:
localhost
Scanning host: localhost
Port OPEN: 135
Port OPEN: 445
Scan completed.
```

The open ports may be different on your machine depending on which services are running.

## How It Works

The scanner uses the first command-line argument as the target host. If no argument is provided, it asks for the host interactively.

Then it tries to create a socket connection to each port in the range `1-1024`.

If the connection succeeds, the port is considered open:

```text
Port OPEN: 135
```

If the connection fails or times out, the port is treated as closed and is not printed.

The current timeout is `200 ms` per port.

## Common Local Ports

Some common ports you may see on local machines:

- `22`: SSH
- `80`: HTTP
- `135`: Windows RPC
- `443`: HTTPS
- `445`: SMB / Windows file sharing

## Current Limitations

- The port range is hardcoded from `1` to `1024`
- It scans ports sequentially
- It does not identify services automatically
- It does not include automated tests yet

## Future Improvements

- Accept start and end ports as command-line arguments
- Show common service names for known ports
- Count and display the total number of open ports
- Improve output formatting

## Ethics

Use this tool only on `localhost`, your own machines, or explicit lab environments where you have permission. Do not use it to scan systems you do not own or administer.
