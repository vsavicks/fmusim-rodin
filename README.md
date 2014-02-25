Rodin Multi-Simulation
======================

Multi-simulation environment for the [Rodin](http://sourceforge.net/projects/rodin-b-sharp/) platform based on the [FMI](https://www.fmi-standard.org) standard.

Enables graphical composition and co-simulation of Event-B machines and imported FMUs.

Installation
------------
Currently can only be run from the source, i.e. an Eclipse workspace. To set up the development environment follow these steps:

1. Set up a development environment for the [ProB 2.0](https://github.com/bendisposto/prob2) according to the instructions on the prob2 repository. Ensure that ProB is up and running. An easy way to do this is to open a Groovy console and load an Event-B machine via command `api.eventb_load("/home/pathToFile/example.bum")`.
2. Clone this repository and import it into the same workspace.
3. Open the target file **/ac.soton.fmusim.components/prob_gmf.target**, wait until Eclipse finishes resolving target definitions and set it as a target by clicking **Set as Target Platform** in the upper right corner.

Usage
-----
* To create a co-simulation (component) diagram right-click on a project and select **New > Components Diagram**.
* To import a component click on the **Import** icon from the toolbar (when the diagram editor is active) and follow the Import wizard. Event-B components require at least one Wait event and, if inputs exist, a Read Input event to be defined, as well as a step period. Input/Output ports can be added from the wizard.
* Components can be connected via input/output ports using **Connectors** and **Links**.
* Simulation can be started by clicking on the **Simulate** icon and entering a simulation time and step size. Automatic validation will be executed prior the simulation to verify that connected port types are compatible.
* To see the simulation results add some **Display** components to the diagram and link them to the output ports of components, whose signals you would like to observe. Double-clicking on a Display component opens a plot window.

Bug Reports/Improvements
------------------------
If you notice a bug or have a good idea on improvement, please add it to the [open issues](https://github.com/snursmumrik/fmusim-rodin/issues?state=open).
