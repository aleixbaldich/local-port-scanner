# Local Port Scanner

Local Port Scanner is a simple Java command-line tool that checks which ports are open on a host provided by the user.

This project is intended as a beginner-friendly networking and cybersecurity exercise. It focuses on learning how sockets, ports, and local services work in a safe lab environment.

## Features

- Accepts the target host as a command-line argument
- Asks for the target host interactively if no argument is provided
- Accepts the highest port to scan as a command-line argument
- Asks for the highest port to scan interactively if no argument is provided
- Prints open ports with known service names when available
- Counts and displays the total number of open ports found
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

Then enter a host and a port limit when prompted:

```text
Enter host to scan:
localhost
Enter how many ports do you want to scan:
1024
```

Or pass the host and port limit directly as arguments:

```bash
java -cp out PortScanner localhost 1024
```

You can also use a local or lab IP address that you own or have permission to scan:

```bash
java -cp out PortScanner 127.0.0.1 1024
```

Example output on Windows:

```text
Enter host to scan:
localhost
Enter how many ports do you want to scan:
1024
Scanning host: localhost
Port OPEN: 135 Windows RPC
Port OPEN: 445 SMB / Windows file sharing
Total open ports: 2
Scan completed.
```

The open ports may be different on your machine depending on which services are running.

## How It Works

The scanner uses the first command-line argument as the target host. If no argument is provided, it asks for the host interactively.

The scanner uses the second command-line argument as the highest port to scan. If no argument is provided, it asks for the limit interactively.

Then it tries to create a socket connection to each port from `1` up to that limit.

If the connection succeeds, the port is considered open:

```text
Port OPEN: 135 Windows RPC
```

If the connection fails or times out, the port is treated as closed and is not printed.

The current timeout is `200 ms` per port.

The program keeps a small built-in list of known ports and service names. If a port is not in that list, it is shown as `Unknown service`.

At the end of the scan, the program prints the total number of open ports found.

## Common Local Ports

Some common ports you may see on local machines:

- `20`: FTP data
- `21`: FTP control
- `22`: SSH
- `23`: Telnet
- `25`: SMTP
- `53`: DNS
- `80`: HTTP
- `135`: Windows RPC
- `443`: HTTPS
- `445`: SMB / Windows file sharing

## Current Limitations

- The port range starts at `1`
- It scans ports sequentially
- It only knows a small built-in list of common services
- It does not include automated tests yet

## Future Improvements

- Accept start and end ports as command-line arguments
- Expand the built-in list of known ports
- Improve output formatting

## Ethics

Use this tool only on `localhost`, your own machines, or explicit lab environments where you have permission. Do not use it to scan systems you do not own or administer.
