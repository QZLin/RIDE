package model;

public class data {
    public static final String builder_py = "import subprocess\n" +
            "from os.path import join\n" +
            "from threading import Thread\n" +
            "from time import sleep\n" +
            "from winreg import OpenKey, HKEY_CURRENT_USER, QueryValueEx\n" +
            "\n" +
            "from config import *\n" +
            "\n" +
            "\n" +
            "def build_mod(project, mod, version, *steps):\n" +
            "    argument = 'cmd,%s,%s,%s,' % (project, mod, version)\n" +
            "    for x in steps:\n" +
            "        if type(x) == list:\n" +
            "            for y in x:\n" +
            "                argument += str(y) + ','\n" +
            "        else:\n" +
            "            argument += str(x) + ','\n" +
            "\n" +
            "    cmd = join(sdk_path, 'msauto.exe')\n" +
            "    print('CMD>>> %s %s' % (cmd, argument))\n" +
            "    subprocess.call(cmd + ' ' + argument, cwd=sdk_path)\n" +
            "\n" +
            "\n" +
            "def launch():\n" +
            "    def get_document():\n" +
            "        key = OpenKey(HKEY_CURRENT_USER, r'Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\Shell Folders')\n" +
            "        return QueryValueEx(key, \"Personal\")[0]\n" +
            "\n" +
            "    def _run():\n" +
            "        subprocess.call('taskkill /F /IM RA3.exe')\n" +
            "        subprocess.call('taskkill /F /IM ra3_1.12.game')\n" +
            "\n" +
            "        mod_path = join(get_document(), r'Red Alert 3\\Mods', project_folder)\n" +
            "        config_file = join(mod_path, '%s_%s.skudef' % (mod_name, version_str))\n" +
            "\n" +
            "        ra3exe = join(ra3_path, 'RA3.exe ')\n" +
            "        argument = r'-modconfig \"%s\"' % config_file\n" +
            "        cmd = ra3exe + ' ' + argument\n" +
            "\n" +
            "        print('Launch RedAlert3')\n" +
            "        print('CMD>>> %s' % cmd)\n" +
            "        subprocess.Popen(cmd, cwd=ra3_path)\n" +
            "\n" +
            "    thread = Thread(target=_run)\n" +
            "    thread.start()\n" +
            "\n" +
            "    sleep(3)\n" +
            "    print()\n" +
            "    input('Press enter to exit RedAlert3')\n" +
            "\n" +
            "    subprocess.Popen('taskkill /F /IM RA3.exe')\n" +
            "    subprocess.Popen('taskkill /F /IM ra3_1.12.game')\n" +
            "\n" +
            "\n" +
            "if mode == MODE_BUILD_ONLY:\n" +
            "    build_mod(project_folder, mod_name, version_str, build_steps)\n" +
            "elif mode == MODE_RUN_ONLY:\n" +
            "    launch()\n" +
            "else:\n" +
            "    build_mod(project_folder, mod_name, version_str, build_steps)\n" +
            "    launch()\n";

    public static final String config_py = "MODE_BUILD_ONLY = 0\n" +
            "MODE_RUN_ONLY = 1\n" +
            "MODE_BUILD_RUN = 2\n" +
            "\n" +
            "sdk_path = r''\n" +
            "ra3_path = r''\n" +
            "\n" +
            "mode = MODE_BUILD_RUN\n" +
            "\n" +
            "project_folder = ''\n" +
            "mod_name = ''\n" +
            "version_str = ''\n" +
            "build_steps = [1, 2, 4, 5, 8, 9, 10]\n";

    public static final String mod_xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<AssetDeclaration xmlns=\"uri:ea.com:eala:asset\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
            "    <Tags/>\n" +
            "    <Includes>\n" +
            "        <!--Do not delete text below-->\n" +
            "        <Include type=\"reference\" source=\"DATA:static.xml\"/>\n" +
            "        <Include type=\"reference\" source=\"DATA:global.xml\"/>\n" +
            "        <Include type=\"reference\" source=\"DATA:audio.xml\"/>\n" +
            "\n" +
            "        <!--Add you text after this-->\n" +
            "        <!--<Include type=\"all\" source=\"yourXml.xml\"/>-->\n" +
            "\n" +
            "\n" +
            "    </Includes>\n" +
            "</AssetDeclaration>";

    public static final String weapon_xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
            "<AssetDeclaration xmlns=\"uri:ea.com:eala:asset\">\n" +
            "    <Tags/>\n" +
            "    <Includes>\n" +
            "        <Include\n" +
            "                type=\"all\"\n" +
            "                source=\"DATA:GlobalData/GlobalDefines.xml\"/>\n" +
            "    </Includes>\n" +
            "    <Defines>\n" +
            "        <!-- thaw rate -->\n" +
            "        <Define name=\"FACTION_WEAPON_SECONDARY_DAMAGE_AMOUNT\" value=\"-500.0\"/>\n" +
            "\n" +
            "        <Define name=\"EMPERORS_RESOLVE_AFFECTS\" value=\"ALLIES NEUTRALS ENEMIES\"/>\n" +
            "    </Defines>\n" +
            "\n" +
            "    <!--Add `<WeaponTemplate>...</WeaponTemplate>` after this-->\n" +
            "\n" +
            "\n" +
            "</AssetDeclaration>";

    public static final String portrait_xml = "<?xml version='1.0' encoding='UTF-8'?>\n" +
            "<AssetDeclaration xmlns=\"uri:ea.com:eala:asset\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
            "\n" +
            "    <Texture id=\"PortraitTextureID\" File=\"TGAImage.tga\" OutputFormat=\"A8R8G8B8\"\n" +
            "             GenerateMipMaps=\"false\" AllowAutomaticResize=\"false\"/>\n" +
            "    <PackedTextureImage id=\"PortraitID\" Texture=\"PortraitTextureID\" Rotated=\"false\">\n" +
            "        <Dimensions x=\"128\" y=\"128\"/>\n" +
            "        <Coords x=\"0\" y=\"0\"/>\n" +
            "        <TextureDimensions x=\"128\" y=\"128\"/>\n" +
            "    </PackedTextureImage>\n" +
            "\n" +
            "</AssetDeclaration>";

    public static final String armor_xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<AssetDeclaration xmlns=\"uri:ea.com:eala:asset\">\n" +
            "    <Tags/>\n" +
            "    <Includes/>\n" +
            "\n" +
            "    <ArmorTemplate\n" +
            "            id=\"NewArmor\">\n" +
            "        <Armor\n" +
            "                Damage=\"ROCKET\"\n" +
            "                Percent=\"100\"/>\n" +
            "        <Armor\n" +
            "                Damage=\"GUN\"\n" +
            "                Percent=\"100\"/>\n" +
            "        <Armor\n" +
            "                Damage=\"EXPLOSIVE\"\n" +
            "                Percent=\"100\"/>\n" +
            "        <Armor\n" +
            "                Damage=\"PRISM\"\n" +
            "                Percent=\"100\"/>\n" +
            "        <Armor\n" +
            "                Damage=\"TESLA\"\n" +
            "                Percent=\"100\"/>\n" +
            "    </ArmorTemplate>\n" +
            "\n" +
            "</AssetDeclaration>";
}
