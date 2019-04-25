package com.Go94;

/**
 * The AvatarImageName is used split the image url address into
 * image name like hulk etc.
 * @author Tibo Siris
 */
class AvatarImageName {

    /**
     * Takes the file URL and returns a name string.
     * @param fileUrl original fileUrl location of avatar.
     * @return shortened name string for the avatar.
     */
    public static String getImageName(final String fileUrl) {
        if (!fileUrl.isEmpty()) {
            String[] sp = fileUrl.split("/");
            String fullName = sp[sp.length - 1];
            String[] name = fullName.split(".png");
            return name[0];
        }
        return "";
    }
}
