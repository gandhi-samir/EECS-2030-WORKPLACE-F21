package model;

public class Account {
	String name = "";
	AppStore store;
	String status = "";
	String[] namesOfDownloadedApps = new String[0];
	App[] objectsOfDownloadedApps = new App[0];

	public Account(String name, AppStore store) {
		this.name = name;
		this.store = store;
		status = "An account linked to the " + store.branch + " store is created for " + name + ".";
	}

	public String[] getNamesOfDownloadedApps() {
		if (objectsOfDownloadedApps.length >= 1) {
			namesOfDownloadedApps = new String[objectsOfDownloadedApps.length];
			for (int i = 0; i < objectsOfDownloadedApps.length; i++) {
				namesOfDownloadedApps[i] = objectsOfDownloadedApps[i].getName();
			}
		}
		return namesOfDownloadedApps;
	}

	public App[] getObjectsOfDownloadedApps() {

		return objectsOfDownloadedApps;
	}

	public void uninstall(String appName) {
		int index = 0;
	boolean isDownloaded=false;
		if (objectsOfDownloadedApps.length > 1) {
			for (int i = 0; i < objectsOfDownloadedApps.length; i++) {
				if (objectsOfDownloadedApps[i].getName().equals(appName)) {
				
					index = i;
					App[] temp = objectsOfDownloadedApps;
					objectsOfDownloadedApps = new App[objectsOfDownloadedApps.length - 1];
					for (int j = 0; j < index; j++) {
						objectsOfDownloadedApps[j] = temp[j];
					}
					for (int k = index + 1; k < temp.length; k++) {
						objectsOfDownloadedApps[k - 1] = temp[k];

					}
					status = appName + " is successfully uninstalled for " + name + ".";
					isDownloaded=true;
					break;
				}
			}
		}
		

		else if (objectsOfDownloadedApps.length == 1 && objectsOfDownloadedApps[0].getName().equals(appName)) {

			objectsOfDownloadedApps = new App[0];
			status = appName + " is successfully uninstalled for " + name + ".";
			isDownloaded=true;

		} if(isDownloaded==false) {
		
			status = "Error: " + appName + " has not been downloaded for " + name + ".";
		}
	}

	public void submitRating(String appName, int rating) {
		if (objectsOfDownloadedApps.length >= 1) {
			for (int i = 0; i < objectsOfDownloadedApps.length; i++) {
				if (objectsOfDownloadedApps[i].getName().equals(appName)) {
					objectsOfDownloadedApps[i].submitRating(rating);
					status = "Rating score " + rating + " of " + name + " is successfully submitted for " + appName
							+ ".";
					break;
				} else {
					status = "Error: " + appName + " is not a downloaded app for " + name + ".";
				}

			}
		} else {
			status = "Error: " + appName + " is not a downloaded app for " + name + ".";
		}

	}

	public void switchStore(AppStore appStore) {
		this.store = appStore;
		status = "Account for " + name + " is now linked to the " + store.branch + " store.";

	}

	public String toString() {
		return status;

	}

	public void download(String appName) {
		boolean isDownloaded = false;
		if (objectsOfDownloadedApps.length >= 1) {
			for (int i = 0; i < objectsOfDownloadedApps.length; i++) {
				if (objectsOfDownloadedApps[i].getName().equals(appName)&&objectsOfDownloadedApps.length<50) {
					isDownloaded = true;
					status = "Error: " + appName + " has already been downloaded for " + name + ".";
					break;
				}
			}
			if (isDownloaded == false&&objectsOfDownloadedApps.length<50) {
				App temp[] = objectsOfDownloadedApps;
				objectsOfDownloadedApps = new App[objectsOfDownloadedApps.length + 1];

				for (int j = 0; j < temp.length; j++) {
					objectsOfDownloadedApps[j] = temp[j];

				}
				objectsOfDownloadedApps[objectsOfDownloadedApps.length - 1] = store.getApp(appName);

				status = appName + " is successfully downloaded for " + name + ".";

			}

		} else if(objectsOfDownloadedApps.length<50) {
			objectsOfDownloadedApps = new App[objectsOfDownloadedApps.length + 1];
			objectsOfDownloadedApps[0] = store.getApp(appName);

			status = appName + " is successfully downloaded for " + name + ".";

		}
	}

}
